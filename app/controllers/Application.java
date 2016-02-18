package controllers;

import models.RoleBean;
import models.UserBean;
import play.mvc.*;
import views.html.*;
import java.util.*;

public class Application extends Controller {
    public Result index() {

        RoleBean role = new RoleBean();
        role.name = "test";
        role.save();


        return ok("12");
    }
}
