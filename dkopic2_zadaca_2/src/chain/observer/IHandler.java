package chain.observer;

/**
 * Created by domagoj on 11/18/16.
 */
public abstract class IHandler {
    public IHandler nextHandler;

    public abstract void setNextHandler (IHandler handler);
    public abstract void handleRequest(String name);
}
