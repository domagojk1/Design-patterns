package chain;

import chain.observer.IHandler;
import factoryMethod.Worker;
import factoryMethod.WorkerFactory;
import utils.DiveEvent;
import utils.SafetyManager;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by domagoj on 11/15/16.
 */
public class ChainGenerator {

    private static IHandler getAlgorithmHandler(ArrayList<DiveEvent> events, Worker worker) {
        ArrayList<DiveEvent> orderedGroups = worker.setDivingGroups(events);
        int securityLevel = SafetyManager.calculateSafetyLevels(orderedGroups);
        return new AlgorithmHandler(securityLevel, orderedGroups);
    }

    public static IHandler getAlgorithmChain(ArrayList<String> algorithms, ArrayList<DiveEvent> diveEvents) {
        ArrayList<IHandler> handlers = new ArrayList<>();
        WorkerFactory factory = new WorkerFactory();
        ArrayList<DiveEvent> orderedGroups;
        Worker worker;

        for (String algorithm : algorithms) {
            worker = factory.getWorker(algorithm);

            if (worker != null) {
                orderedGroups = worker.setDivingGroups(diveEvents);
                handlers.add(getAlgorithmHandler(orderedGroups, worker));
            }

            Iterator<IHandler> iterator = handlers.iterator();
            IHandler handler, handlerAccessor;

            if (handlers.size() > 1) {
                while (iterator.hasNext()) {
                    handler = iterator.next();
                    handlerAccessor = iterator.next();
                    handler.setNextHandler(handlerAccessor);

                    if (iterator.hasNext()) {
                        handlerAccessor.setNextHandler(iterator.next());
                    }
                }
            }
        }

        if (handlers.size() > 0) {
            return handlers.get(0);
        }
        else return null;
    }
}
