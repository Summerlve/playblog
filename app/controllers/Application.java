package controllers;

import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;
import play.mvc.*;

@Restrict(@Group("Admin"))
public class Application extends Controller {
    public Result index() {
        return ok();
    }
}
