package models.user;

import models.RoleBean;
import models.UserBean;
import java.util.Set;

/**
 * Created by Summer on 2016/2/27.
 */
public class UserRepositoryImplement implements UserRepository{
    @Override
    public Set<RoleBean> findUserRoles(UserBean user) {
        return null;
    }
}
