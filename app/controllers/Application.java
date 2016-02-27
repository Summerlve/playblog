package controllers;

import models.RoleBean;
import models.UserBean;
import play.mvc.*;

public class Application extends Controller {
    public Result index() {
        return ok();
    }
}
