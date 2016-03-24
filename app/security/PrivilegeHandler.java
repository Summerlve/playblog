package security;

import be.objectify.deadbolt.core.models.Subject;
import be.objectify.deadbolt.java.AbstractDeadboltHandler;
import be.objectify.deadbolt.java.DynamicResourceHandler;
import models.UserBean;
import play.libs.F;
import play.mvc.Http;
import play.mvc.Result;

import java.util.Optional;
import play.Logger;

/**
 * Created by Summer on 3/24/16.
 */
public class PrivilegeHandler extends AbstractDeadboltHandler {
    @Override
    public F.Promise<Optional<Subject>> getSubject(Http.Context context) {
        Logger.trace("id is:", context.session().get("id"));
        String userId = Optional.ofNullable(context.session().get("id")).orElse("");
        return F.Promise.promise(() -> Optional.ofNullable(UserBean.find.byId(Long.valueOf(userId))));
    }

    @Override
    public F.Promise<Optional<Result>> beforeAuthCheck(Http.Context context) {
        return F.Promise.pure(Optional.empty());
    }

    @Override
    public F.Promise<Result> onAuthFailure(Http.Context context, String content) {
        return F.Promise.promise(() -> unauthorized());
    }

    @Override
    public F.Promise<Optional<DynamicResourceHandler>> getDynamicResourceHandler(Http.Context context) {
        return F.Promise.pure(Optional.empty());
    }
}
