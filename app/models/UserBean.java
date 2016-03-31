package models;

import be.objectify.deadbolt.core.models.Permission;
import be.objectify.deadbolt.core.models.Subject;
import com.avaje.ebean.Model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Summer on 2016/2/11.
 */

@Entity
@Table(name = "user")
public class UserBean extends Model implements Subject {
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

    @Override
    public List<RoleBean> getRoles() {
        return roles;
    }

    @Override
    public List<? extends Permission> getPermissions() {
        List<PermissionBean> permissions = new ArrayList<>();
        roles.stream().forEach(role -> role.permissions.stream().forEach(permissions::add));
        return permissions;
    }

    @Override
    public String getIdentifier() {
        return String.valueOf(this.id); // use Long id -> String as identifier
    }

    public static final Finder<Long, UserBean> find = new Finder<Long, UserBean>(UserBean.class);
}
