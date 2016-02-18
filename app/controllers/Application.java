package controllers;

import models.UserBean;
import play.mvc.*;
import views.html.*;
import java.util.*;

public class Application extends Controller {
    public Result index() {
        UserBean user = new UserBean();
        user.username = "test";
        user.pen_name = "test";
        user.password_hash = "123123123";
//        user.insert();

        List<UserBean> users = UserBean.find.all();


        return ok(users.size() + "");
    }
}
