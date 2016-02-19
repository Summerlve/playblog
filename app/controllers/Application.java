package controllers;

import models.RoleBean;
import models.UserBean;
import play.mvc.*;

public class Application extends Controller {
    public Result index() {
        RoleBean role = new RoleBean();
        role.name = "test";

        if (RoleBean.create(role) != null) {
            UserBean user = new UserBean();
            user.username = "123";
            user.pen_name = "123";
            user.password_hash = "123";

            if (UserBean.create(user, role) != null) {
                return ok("success");
            }
            else {
                return ok("failed");
            }
        }
        else {
            return ok("failed");
        }
    }
}
