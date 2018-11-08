package swingy.interface;

import swingy.interface.IObserver;

public interface IObservable
{
    public void addObserver(swingy.interface.IObserver observer);
    public void notifyObserver(String notification);
}