package swingy.Controller;

import swingy.model.AbstractModel;

public abstract class AbstractController {
    protected AbstractModel model;

    abstract void   dispatch();
    abstract void   reset();
}
