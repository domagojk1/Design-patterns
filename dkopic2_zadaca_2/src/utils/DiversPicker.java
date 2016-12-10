package utils;

import builder.Diver;
import builder.Schedule;

import java.util.*;

/**
 * Created by domagoj on 10/17/16.
 */
public class DiversPicker {

    public static ArrayList<DiveEvent> generateDiveEvents(int seed, ArrayList<Diver> divers, ArrayList<Schedule> schedules) {
        ArrayList<Diver> chosenDivers;
        ArrayList<DiveEvent> diveEvents = new ArrayList<>();
        Random random = new Random(seed);

        for (Schedule schedule : schedules) {
            boolean sameDate = false;
            chosenDivers = new ArrayList<>();

            if (diveEvents.size() > 0) {
                for (DiveEvent event : diveEvents) {
                    if (event.getSchedule().getDivingDate().equals(schedule.getDivingDate())) {
                        ArrayList<Diver> mDivers = event.getDivers();
                        for (Diver diver : mDivers) {
                            try {
                                chosenDivers.add((Diver)diver.clone());
                            } catch (CloneNotSupportedException ex) {
                                ex.printStackTrace();
                            }
                        }
                        sameDate = true;
                    }
                }
            }
            if (!sameDate) {
                ArrayList<Diver> diversCopy = new ArrayList<>();
                for (Diver diver : divers) {
                    try {
                        diversCopy.add((Diver)diver.clone());
                    } catch (CloneNotSupportedException ex) {
                        ex.printStackTrace();
                    }
                }

                for (int i = 0; i < schedule.getDiversNum(); i++) {
                    Diver diver = diversCopy.get(random.nextInt(diversCopy.size()));
                    diversCopy.remove(diver);

                    chosenDivers.add(diver);
                }
            }

            DiveEvent event = new DiveEvent(chosenDivers, schedule);
            diveEvents.add(event);
        }

        return diveEvents;
    }
}
