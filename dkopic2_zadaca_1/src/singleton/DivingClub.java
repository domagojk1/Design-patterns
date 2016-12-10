package singleton;

import builder.Diver;
import builder.Schedule;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Singleton class which represents one diving club
 */
public class DivingClub {
    private static DivingClub instance = new DivingClub();
    private ArrayList<Schedule> schedules;
    private ArrayList<Diver> divers;

    private DivingClub() {
    }

    public static DivingClub getInstance() {
        return instance;
    }

    public void buildSchedules(String scheduleFile) {
        if (schedules == null) {
            schedules = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(scheduleFile))) {
                String line;
                try {
                    while ((line = br.readLine()) != null) {
                        Schedule schedule = new Schedule.ScheduleBuilder(line).build();
                        schedules.add(schedule);
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            catch (FileNotFoundException e) {
                System.out.println("Datoteka " + scheduleFile + " ne postoji.");
            }
            catch (IOException e) {
                System.out.println("Pogreska prilikom citanja datoteke " + scheduleFile + ".");
            }
        }
    }

    public void buildDivers(String diversFile) {
        if (divers == null) {
            divers = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(diversFile))) {
                String line;
                try {
                    while ((line = br.readLine()) != null) {
                        Diver diver = new Diver.DiverBuilder(line).build();
                        divers.add(diver);
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            catch (FileNotFoundException e) {
                System.out.println("Datoteka " + diversFile + " ne postoji.");
            }
            catch (IOException e) {
                System.out.println("Pogreska prilikom citanja datoteke " + diversFile + ".");
            }
        }
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    public ArrayList<Diver> getDivers() {
        return divers;
    }
}
