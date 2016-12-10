package feature;

import builder.Diver;
import builder.Schedule;

import java.util.ArrayList;

/**
 * Represents one diving event
 */
public class DiveEvent {
    private ArrayList<Diver> divers;
    private Schedule schedule;

    public DiveEvent(ArrayList<Diver> divers, Schedule schedule) {
        this.divers = divers;
        this.schedule = schedule;
    }

    public ArrayList<Diver> getDivers() {
        return divers;
    }

    public void setDivers(ArrayList<Diver> divers) {
        this.divers = divers;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
