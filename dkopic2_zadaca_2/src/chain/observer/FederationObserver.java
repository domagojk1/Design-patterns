package chain.observer;

import chain.observer.singleton.DivingClub;
import utils.DiveEvent;

/**
 * Created by domagoj on 11/18/16.
 */
public class FederationObserver extends IHandler implements Observer {
    private String name;
    private Subject subject;

    public FederationObserver(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public IHandler getNextHandler() { return this.nextHandler; }

    @Override
    public void setNextHandler(IHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(String name) {
        if (this.name.equals(name)) {
            update();
        }
        else if (this.name.equals(DivingClub.getInstance().getAllianceObserver().getName())) {
            nextHandler.handleRequest(name);
        }
        else {
            if (nextHandler != null) nextHandler.handleRequest(name);
        }
    }

    @Override
    public void update() {
        DiveEvent event = subject.getUpdate();
        System.out.println("Ronioc " + event.getDivers().get(0).getName() + " roni pod organizacijom " + name);
        System.out.println("Razina sigurnosti: " + event.getSafetyLevel());
        System.out.println("Vrijeme urona: " + event.getSchedule().getDivingDate() + " " + event.getSchedule().getDivingTime());
        System.out.println("------------------------------------------------\n");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FederationObserver that = (FederationObserver) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return subject != null ? subject.equals(that.subject) : that.subject == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        return result;
    }
}
