
package feature;

import builder.Diver;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by domagoj on 10/18/16.
 */
public class RandomWorker implements Worker {
    @Override
    public ArrayList<DiveEvent> orderGroups(ArrayList<DiveEvent> diveEvents) {
        ArrayList<DiveEvent> dives = new ArrayList<>();

        for (DiveEvent event : diveEvents){
            ArrayList<Diver> divers = event.getDivers();
            Collections.shuffle(divers);

            if (event.getDivers().size() % 2 == 0) {
                for (int i = 0; i < divers.size(); i += 2) {
                    ArrayList<Diver> diversToDive = new ArrayList<>();

                    diversToDive.add(divers.get(i));
                    diversToDive.add(divers.get(i + 1));

                    DiveEvent diveEvent = new DiveEvent(diversToDive, event.getSchedule());
                    dives.add(diveEvent);
                }
            }
            else {
                for (int i = 0; i < divers.size(); i += 3) {
                    ArrayList<Diver> diversToDive = new ArrayList<>();

                    if (divers.size() - i == 2) {
                        diversToDive.add(divers.get(i));
                        diversToDive.add(divers.get(i + 1));
                    }
                    else if (divers.size() - i == 1) {
                        //diversToDive.add(divers.get(i));
                    }
                    else {
                        diversToDive.add(divers.get(i));
                        diversToDive.add(divers.get(i + 1));
                        diversToDive.add(divers.get(i + 2));
                    }

                    DiveEvent diveEvent = new DiveEvent(diversToDive, event.getSchedule());
                    dives.add(diveEvent);
                }
            }
        }

        return Helper.setDepths(dives);
    }
}
