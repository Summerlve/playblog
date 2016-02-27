package models.user;

import models.RoleBean;
import models.UserBean;

import java.util.Set;

/**
 * Created by Summer on 2016/2/27.
 */
public interface UserRepository {
    Set<RoleBean> findUserRoles (UserBean user);
}
