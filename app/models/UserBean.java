package models;

import com.avaje.ebean.Model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Summer on 2016/2/11.
 */

@Entity
@Table(name = "user")
public class UserBean extends Model {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "username", nullable = false, unique = true, columnDefinition = "varchar(255) CHARACTER SET utf8 COLLATE utf8_bin")
    public String username;

    @Column(name = "password_hash", length = 255, nullable = false)
    public String passwordHash;

    @Column(name = "pen_name", nullable = false, unique = true, columnDefinition = "varchar(255) CHARACTER SET utf8 COLLATE utf8_bin")
    public String penName;

    @Column(name = "avatar", length = 255)
    public String avatar;

    @Column(name = "introduce", length = 255)
    public String introduce;

    @ManyToMany
    @JoinTable(
        name = "user_role",
        joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
        },
        inverseJoinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
        }
    )
    public List<RoleBean> roles = new ArrayList<RoleBean>();

    @OneToMany(mappedBy = "creater", cascade = CascadeType.ALL)
    public List<ArticleBean> createdArticles = new ArrayList<ArticleBean>();

    @OneToMany(mappedBy = "updater", cascade = CascadeType.ALL)
    public List<ArticleBean> updatedArticles = new ArrayList<ArticleBean>();

    public static UserBean create (UserBean user, RoleBean role) {
        // when user exists, it can not be create success beacause of the uniqe username field. so return null.
        if (UserBean.isExists(user)) return null;
        // if role do not exists, create user must failed.
        if (!RoleBean.isExists(role)) return null;

        if (role.id == null) {
            role = RoleBean.find.where().eq("name", role.name).findUnique();
        }

        user.roles.add(role);
        user.save();

        return user;
    }

    public static boolean isExists (UserBean user) {
        if (user.id != null) return UserBean.find.byId(user.id) != null;

        if (UserBean.find.where().eq("username", user.username).findList().size() != 0) return true;

        if (UserBean.find.where().eq("pen_name", user.penName).findList().size() != 0) return true;

        return false;
    }

    public static final Finder<Long, UserBean> find = new Finder<Long, UserBean>(UserBean.class);
}
