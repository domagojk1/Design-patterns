import builder.Diver;
import builder.Schedule;
import feature.*;
import singleton.DivingClub;

import java.util.ArrayList;

/**
 * Main class
 */

public class DivingTest {
    /**
     * first arg - random generator seed
     * second arg - divers file name
     * third arg - schedule file name
     * fourth arg - algorithm name
     * fivth arg - output file name
     * @param args
     */
    public static void main (String[] args) {

        if (args.length == 5) {
            int seed = Integer.parseInt(args[0]);

            if (seed > 100) {
                String diversFileName = args[1];
                String schedulesFileName = args[2];
                String scheduleAlg = args[3];
                String outputFileName = args[4];

                DivingClub producer = DivingClub.getInstance();
                producer.buildDivers(diversFileName);
                producer.buildSchedules(schedulesFileName);

                ArrayList<Diver> divers = producer.getDivers();
                ArrayList<Schedule> schedules = producer.getSchedules();
                ArrayList<DiveEvent> diveEvents = new DiversPicker().generateDiveEvents(seed, divers, schedules);

                switch (scheduleAlg) {
                    case "AlgMaksUron":
                        dive(new MaxDepthWorker(), diveEvents, outputFileName);
                        break;
                    case "AlgMaksRazina":
                        dive(new MaxLevelWorker(), diveEvents, outputFileName);
                        break;
                    case "Nasumicno":
                        dive(new RandomWorker(), diveEvents, outputFileName);
                        break;
                    default: 
                        System.out.println("Algoritam pod nazivom " + scheduleAlg + " ne postoji.");
                        break;
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


    private static void dive (Worker worker, ArrayList<DiveEvent> diveEvents, String outputFile) {
        ArrayList<DiveEvent> dives = worker.orderGroups(diveEvents);
        FileWriter.write(outputFile, dives);
    }
}
