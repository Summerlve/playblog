package controllers;

import models.RoleBean;
import models.UserBean;
import play.mvc.*;

public class Application extends Controller {
    public Result index() {
        RoleBean role = new RoleBean();
        role.name = "test";
        RoleBean.create(role);

        UserBean user = new UserBean();
        user.username = "123123123123";
        user.passwordHash = "123";
        user.penName = "123";

        UserBean.create(user, role);

        return ok(role.toString());
    }
}
