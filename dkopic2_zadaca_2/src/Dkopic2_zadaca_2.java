/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import builder.Diver;
import builder.Schedule;
import chain.ChainGenerator;
import chain.observer.IHandler;
import chain.observer.singleton.DivingClub;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import utils.DiveEvent;
import utils.DiversPicker;
import visitor.DiverConcreteVisitor;

/**
 *
 * @author domagoj
 */
public class Dkopic2_zadaca_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 7) {
            int seed = Integer.parseInt(args[0]);

            if (seed > 100) {
                String diversFileName = args[1];
                String schedulesFileName = args[2];
                String outputFileName = args[6];

                DivingClub producer = DivingClub.getInstance();
                producer.buildDivers(diversFileName);
                producer.buildSchedules(schedulesFileName);

                ArrayList<Diver> divers = producer.getDivers();
                ArrayList<Schedule> schedules = producer.getSchedules();
                ArrayList<DiveEvent> diveEvents = DiversPicker.generateDiveEvents(seed, divers, schedules);

                ArrayList<String> algorithms = new ArrayList<>();
                if (args[3] != null) algorithms.add(args[3]);
                if (args[4] != null) algorithms.add(args[4]);
                if (args[5] != null) algorithms.add(args[5]);

                IHandler handler = ChainGenerator.getAlgorithmChain(algorithms, diveEvents);
                handler.handleRequest(outputFileName);

                System.out.println("Unesite naziv federacije: ");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                try {
                    String federation = br.readLine();
                    DiverConcreteVisitor visitor = new DiverConcreteVisitor(federation);

                    for (DiveEvent diveEvent : diveEvents) {
                        for (Diver diver : diveEvent.getDivers()) {
                            visitor.visitFederation(diver);
                        }
                    }

                    System.out.println("Broj ronioca federacije " + federation + ": " + visitor.getNumberOfDivers());
                    System.out.println("Prosjecna dozvoljena dubina ronioca: " + visitor.getAverageDiverDepth());
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("Sjeme mora imati minimalno 3 znamenke.");
            }
        }
        else {
            System.out.println("Broj argumenata nije valjan.");
        }
    }
    
}
