package factoryMethod;

import builder.Diver;
import constants.RecreationalLevels;
import utils.DiveEvent;
import utils.Helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by domagoj on 10/18/16.
 */
public class MaxDepthWorker implements Worker {

    @Override
    public ArrayList<DiveEvent> setDivingGroups(ArrayList<DiveEvent> diveEvents) {
        ArrayList<DiveEvent> events = new ArrayList<>();

        for (DiveEvent event : diveEvents) {
            ArrayList<Diver> divers = event.getDivers();
            ArrayList<Diver> lowLevelDivers = new ArrayList<>();
            ArrayList<Diver> highLevelDivers = new ArrayList<>();

            for (Diver diver : divers) {
                String levelSign = diver.getLevel().getLevelSign();

                if (levelSign.startsWith(RecreationalLevels.RECREATIONAL) && Helper.getLevelNumber(levelSign) <= 2) {
                    lowLevelDivers.add(diver);
                } else {
                    highLevelDivers.add(diver);
                }
            }

            Collections.sort(lowLevelDivers);
            Collections.sort(highLevelDivers);
            Iterator<Diver> lowIt = lowLevelDivers.iterator();
            Iterator<Diver> highIt = highLevelDivers.iterator();

            if (divers.size() % 2 == 0) {
                while (lowIt.hasNext()) {
                    ArrayList<Diver> diversToDive = new ArrayList<>();
                    diversToDive.add(lowIt.next());
                    lowIt.remove();

                    if (highIt.hasNext()) {
                        diversToDive.add(highIt.next());
                        highIt.remove();
                    }
                    else if (lowIt.hasNext()){
                        diversToDive.add(lowIt.next());
                        lowIt.remove();
                    }

                    DiveEvent diveEvent = new DiveEvent(diversToDive, event.getSchedule());
                    events.add(diveEvent);
                }
            }
            else {
                while (lowIt.hasNext()) {
                    ArrayList<Diver> diversToDive = new ArrayList<>();
                    diversToDive.add(lowIt.next());
                    lowIt.remove();

                    if (lowIt.hasNext()) {
                        diversToDive.add(lowIt.next());
                        lowIt.remove();
                    }

                    if (highIt.hasNext()) {
                        diversToDive.add(highIt.next());
                        highIt.remove();
                    }
                    else if (lowIt.hasNext()){
                        diversToDive.add(lowIt.next());
                        lowIt.remove();
                    }

                    DiveEvent diveEvent = new DiveEvent(diversToDive, event.getSchedule());
                    events.add(diveEvent);
                }
            }

            if (highLevelDivers.size() % 2 == 0) {
                for (int i = 0; i < highLevelDivers.size(); i += 2) {
                    ArrayList<Diver> diversToDive = new ArrayList<>();

                    diversToDive.add(highLevelDivers.get(i));
                    diversToDive.add(highLevelDivers.get(i + 1));

                    DiveEvent diveEvent = new DiveEvent(diversToDive, event.getSchedule());
                    events.add(diveEvent);
                }
            }
            else {
                for (int i = 0; i < highLevelDivers.size(); i += 3) {
                    ArrayList<Diver> diversToDive = new ArrayList<>();

                    if (highLevelDivers.size() - i == 2) {
                        diversToDive.add(highLevelDivers.get(i));
                        diversToDive.add(highLevelDivers.get(i + 1));
                    }
                    else if (highLevelDivers.size() - i == 1) {
                        //diversToDive.add(highLevelDivers.get(i));
                    }
                    else {
                        diversToDive.add(highLevelDivers.get(i));
                        diversToDive.add(highLevelDivers.get(i + 1));
                        diversToDive.add(highLevelDivers.get(i + 2));
                    }

                    DiveEvent diveEvent = new DiveEvent(diversToDive, event.getSchedule());
                    events.add(diveEvent);
                }
            }
        }

        return Helper.setDepths(events);
    }
}
