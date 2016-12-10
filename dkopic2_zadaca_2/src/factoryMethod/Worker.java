package factoryMethod;

import utils.DiveEvent;

import java.util.ArrayList;

/**
 * Created by domagoj on 10/18/16.
 */
public interface Worker {
    ArrayList<DiveEvent> setDivingGroups(ArrayList<DiveEvent> diveEvents);
}
