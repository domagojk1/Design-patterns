package factoryMethod;

/**
 * Created by domagoj on 11/13/16.
 */
public class WorkerFactory {
    public Worker getWorker(String algorithm) {

        switch (algorithm) {
            case "AlgMaksUron":
                return new MaxDepthWorker();

            case "AlgMaksRazina":
                return new MaxLevelWorker();

            case "Nasumicno":
                return new RandomWorker();

            default:
                System.out.println("Nije podrzan algoritam.");
                break;
        }

        return null;
    }
}
