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

        UserBean user = new UserBean();
        user.username = "123";
        user.pen_name = "123";
        user.password_hash = "123";
        user.roles.add(role);
        user.save();

        return ok("12");
    }
}
