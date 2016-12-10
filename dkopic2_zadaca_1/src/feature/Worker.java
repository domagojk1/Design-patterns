package feature;

import builder.Diver;
import builder.Schedule;

import java.util.ArrayList;

/**
 * Created by domagoj on 10/18/16.
 */
public interface Worker {
    ArrayList<DiveEvent> orderGroups(ArrayList<DiveEvent> diveEvents);
}
