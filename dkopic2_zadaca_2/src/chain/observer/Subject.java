package chain.observer;

import utils.DiveEvent;

/**
 * Created by domagoj on 11/15/16.
 */
public interface Subject {
    void register(FederationObserver concreteObserver);
    void unregister(FederationObserver concreteObserver);
    void notifyObservers(DiveEvent diveEvent);
    void postDiver(DiveEvent diveEvent);
    DiveEvent getUpdate();
}
