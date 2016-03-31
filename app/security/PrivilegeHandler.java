package security;

import be.objectify.deadbolt.core.models.Subject;
import be.objectify.deadbolt.java.AbstractDeadboltHandler;
import be.objectify.deadbolt.java.DynamicResourceHandler;
import play.libs.F;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import java.util.Optional;

/**
 * Created by Summer on 3/24/16.
 */
public class PrivilegeHandler extends AbstractDeadboltHandler {
    @Override
    public F.Promise<Optional<Subject>> getSubject(Http.Context context) {
        // get token from http request header 'Authorization'

        return F.Promise.promise(
                () -> Optional.ofNullable(context.request())
                        .map(value -> value.headers())
                        .map(value -> value.get("Authorization"))
                        .map(value -> value[0])
                        .flatMap(value -> {
                            // get id from token
                            return Optional.ofNullable(null);
                        })
        );
    }

    @Override
    public F.Promise<Optional<Result>> beforeAuthCheck(Http.Context context) {
        return F.Promise.pure(Optional.empty());
    }

    @Override
    public F.Promise<Result> onAuthFailure(Http.Context context, String content) {
        return F.Promise.promise(Results::unauthorized);
    }

    @Override
    public F.Promise<Optional<DynamicResourceHandler>> getDynamicResourceHandler(Http.Context context) {
        return F.Promise.pure(Optional.empty());
    }
}
