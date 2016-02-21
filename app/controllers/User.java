package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.user;

/**
 * Created by Summer on 2016/2/11.
 */
public class User extends Controller {
    public Result index () {
        return ok(user.render("123123"));
    }

    public Result one () {
        return ok();
    }

    public Result add () {
        return ok();
    }

    public Result update () {
        return ok();
    }

    public Result remove () {
        return ok();
    }
}
