package chain;

import chain.observer.IHandler;
import utils.DiveEvent;
import utils.DiveManager;
import utils.FileWriter;
import utils.SafetyManager;

import java.util.ArrayList;

/**
 * Created by domagoj on 11/18/16.
 */
public class AlgorithmHandler extends IHandler {
    private int workerId;
    private ArrayList<DiveEvent> diveEvents;

    public AlgorithmHandler(int workerId, ArrayList<DiveEvent> diveEvents) {
        this.workerId = workerId;
        this.diveEvents = diveEvents;
    }
    @Override
    public void setNextHandler(IHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(String fileName) {
        if (this.workerId == SafetyManager.getMinLevelId()) {
            DiveManager.logDives(diveEvents);
            FileWriter.writeTable(fileName, diveEvents);
        }
        else {
            nextHandler.handleRequest(fileName);
        }
    }
}
