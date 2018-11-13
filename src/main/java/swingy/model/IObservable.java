package swingy.model;

import swingy.view.ui.GameUI;

public interface IObservable {
    public void register(GameUI gameUI);
    public void unregister();
    public void notification();
}
