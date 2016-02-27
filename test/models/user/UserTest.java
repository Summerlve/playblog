package models.user;

import static org.mockito.Mockito.*;
import models.RoleBean;
import models.UserBean;
import org.junit.Test;
import static org.junit.Assert.*;
import play.test.WithApplication;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Summer on 2016/2/27.
 */
public class UserTest extends WithApplication {
    @Test
    public void testIsRoot () {
        UserRepository repositoryMock = mock(UserRepository.class);
        Set<RoleBean> roles = new HashSet<>();
        RoleBean role = new RoleBean();
        role.name = "root";
        roles.add(role);
        when(repositoryMock.findUserRoles(any(UserBean.class))).thenReturn(roles);

        UserService userService = new UserService(repositoryMock);
        UserBean user = new UserBean();
        user.id = 1L;
        user.username = "zhanghao";

        assertTrue(userService.isRoot(user));
        verify(repositoryMock).findUserRoles(user);
    }
}
