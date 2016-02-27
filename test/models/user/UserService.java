package models.user;

import models.RoleBean;
import models.UserBean;
import java.util.Set;

/**
 * Created by Summer on 2016/2/27.
 */
public class UserService {
    private final UserRepository userRepository;
    public UserService (final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isRoot (final UserBean user) {
        final Set<RoleBean> roles = userRepository.findUserRoles(user);
        for (RoleBean role: roles) {
            if (role.name == "root") return true;
        }
        return false;
    }
}
