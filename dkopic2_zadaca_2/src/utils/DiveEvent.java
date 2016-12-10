package utils;

import builder.Diver;
import builder.Schedule;

import java.util.ArrayList;

/**
 * Represents one diving event
 */
public class DiveEvent implements Cloneable{
    private ArrayList<Diver> divers;
    private Schedule schedule;
    private int safetyLevel;

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

    public int getSafetyLevel() {
        return safetyLevel;
    }

    public void setSafetyLevel(int safetyLevel) {
        this.safetyLevel = safetyLevel;
    }

    public void addDiver(Diver diver) {
        this.divers.add(diver);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        DiveEvent diveEvent = new DiveEvent(this.divers, this.schedule);
        diveEvent.setSafetyLevel(this.safetyLevel);
        return diveEvent;
    }
}
