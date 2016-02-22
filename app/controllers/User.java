package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.user;

/**
 * Created by Summer on 2016/2/11.
 */
public class User extends Controller {
    public Result index (String page, String limit) {
        return ok(user.render(page + limit));
    }

    public Result one (Long id) {
        return ok();
    }

    public Result add () {
        return ok();
    }

    public Result update (Long id) {
        return ok();
    }

    public Result remove (Long id) {
        return ok();
    }
}
