package swingy.model;

import swingy.view.ui.GameUI;

public abstract class AbstractModel implements IObservable {
    protected GameUI gameUI;

    public abstract void notification();

    public void register(GameUI gameUI)
    {
        if (gameUI != null)
            this.gameUI = gameUI;
    }

    public void unregister()
    {
        this.gameUI = null;
    }
}
