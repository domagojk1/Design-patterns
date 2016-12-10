package utils;

import builder.Diver;
import chain.observer.singleton.DivingClub;

import java.util.ArrayList;

/**
 * Created by domagoj on 11/15/16.
 */
public class DiveManager {
    private static DivingClub club = DivingClub.getInstance();

    public static void logDives(ArrayList<DiveEvent> diveEvents) {
        for (DiveEvent event : diveEvents) {
            ArrayList<Diver> divers = event.getDivers();

            for (Diver diver : divers) {
                DiveEvent diveEvent = cloneDiveEvent(event, diver);
                club.postDiver(diveEvent);
            }
        }
    }

    private static DiveEvent cloneDiveEvent(DiveEvent event, Diver diver) {
        DiveEvent diveEvent = null;
        try {
            diveEvent = (DiveEvent)event.clone();
            diveEvent.setDivers(new ArrayList<Diver>());
            diveEvent.addDiver(diver);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return diveEvent;
    }
}
