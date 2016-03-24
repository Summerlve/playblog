package security;

import be.objectify.deadbolt.java.DeadboltHandler;
import be.objectify.deadbolt.java.cache.HandlerCache;
import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Summer on 3/24/16.
 */

@Singleton
public class PrivilegeHandlerCache implements HandlerCache {
    private final DeadboltHandler defaultHandler = new PrivilegeHandler();
    private final Map<String, DeadboltHandler> handlers = new HashMap<>();

    public PrivilegeHandlerCache() {
        handlers.put("default", defaultHandler);
    }

    @Override
    public DeadboltHandler get() {
        return defaultHandler;
    }

    @Override
    public DeadboltHandler apply(String s) {
        return handlers.get(s);
    }
}
