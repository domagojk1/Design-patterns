package chain.observer.singleton;

import builder.Diver;
import builder.Schedule;
import chain.observer.FederationObserver;
import chain.observer.Subject;
import utils.DiveEvent;
import utils.FileWriter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Singleton class which represents one diving club
 */
public class DivingClub implements Subject {
    private static DivingClub instance = new DivingClub();
    public static final String HRS = "HRS";
    private FederationObserver allianceObserver;

    private ArrayList<Schedule> schedules;
    private ArrayList<Diver> divers;
    private DiveEvent currentDiveEvent;
    private ArrayList<FederationObserver> observers;

    private Map<FederationObserver, ArrayList<DiveEvent>> observerMap = new LinkedHashMap<>();

    private DivingClub() {
        allianceObserver = new FederationObserver(HRS, this);
        register(allianceObserver);
    }

    public static DivingClub getInstance() {
        return instance;
    }

    public Map<FederationObserver, ArrayList<DiveEvent>> getObserverMap() {
        return observerMap;
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    public ArrayList<Diver> getDivers() {
        return divers;
    }

    @Override
    public DiveEvent getUpdate() {
        return currentDiveEvent;
    }

    public FederationObserver getAllianceObserver() {
        return allianceObserver;
    }

    public void buildSchedules(String scheduleFile) {
        if (schedules == null) {
            schedules = new ArrayList<>();
            ArrayList<Object> objects = FileWriter.readFromFile(scheduleFile, Schedule.class);

            for (Object object : objects) {
                schedules.add((Schedule) object);
            }
        }
    }

    public void buildDivers(String diversFile) {
        if (divers == null) {
            divers = new ArrayList<>();
            ArrayList<Object> objects = FileWriter.readFromFile(diversFile, Diver.class);

            for (Object object : objects) {
                divers.add((Diver) object);
            }
        }
    }

    @Override
    public void register(FederationObserver observer) {
        synchronized (this) {
            this.observerMap.put(observer,null);
        }
    }

    @Override
    public void unregister(FederationObserver observer) {
        synchronized (this) {
            this.observerMap.remove(observer);
        }
    }

    @Override
    public void postDiver(DiveEvent diveEvent) {
        synchronized (this) {
            addDiverToObserver(diveEvent, allianceObserver);
            observers = new ArrayList<>(observerMap.keySet());

            boolean exists = false;

            for (FederationObserver observer : observers) {
                if (observer.getName().equals(diveEvent.getDivers().get(0).getLevel().getFederation())) {
                    addDiverToObserver(diveEvent, observer);
                    exists = true;
                }
            }

            if (!exists) addNewElementToMap(diveEvent);
            notifyObservers(diveEvent);
        }
    }

    private void addDiverToObserver(DiveEvent diveEvent, FederationObserver observer) {
        ArrayList<DiveEvent> diveEvents = observerMap.get(observer);

        if (diveEvents == null) {
            diveEvents = new ArrayList<>();
            observerMap.put(observer, diveEvents);
        }

        diveEvents.add(diveEvent);
    }

    @Override
    public void notifyObservers(DiveEvent diveEvent) {
        synchronized (this) {
            setUpdate(allianceObserver, diveEvent);
            observers.get(0).handleRequest(getFederationName(diveEvent));
        }
    }

    private void setUpdate(FederationObserver observer, DiveEvent diveEvent) {
        currentDiveEvent = diveEvent;
        observer.update();
    }

    private void addNewElementToMap(DiveEvent diveEvent) {
        ArrayList<DiveEvent> events = new ArrayList<>();
        events.add(diveEvent);
        FederationObserver newObserver = new FederationObserver(getFederationName(diveEvent), this);
        observerMap.put(newObserver, events);

        setObserverChain(newObserver);
    }

    private void setObserverChain(FederationObserver federationObserver) {
        observers = new ArrayList<>(getObserverMap().keySet());

        for (FederationObserver observer : observers) {
            if (observer.getNextHandler() == null && !observer.equals(federationObserver)) {
                observer.setNextHandler(federationObserver);
            }
        }
    }

    private String getFederationName(DiveEvent diveEvent) {
        return diveEvent.getDivers().get(0).getLevel().getFederation();
    }
}