package swingy.Model;

import swingy.Interface.IObservable;
import swingy.Interface.IObserver;

public abstract class AbstractModel implements IObservable  {
    private ArrayList<IObserver> observers = new ArrayList<IObserver>();

    public abstract void reset();

    public void addObserver(IObserver observer)
    {
        vers.add(observer);
    }

    public void notifyObserver(String notification)
    {
            for (IObserver observer : observers)
            {
                observer.update("Hellooo I'm Back !");
            }
    }

    public void removeObserver()
    {
        // Surely need to change this in a future.
        observers = new ArrayList<IObserver>();
    }

}
