package models;

import be.objectify.deadbolt.core.models.Role;
import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Summer on 2016/2/11.
 */

@Entity
@Table(name = "role")
public class RoleBean extends Model implements Role {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "varchar(255) CHARACTER SET utf8 COLLATE utf8_bin")
    public String name;

    @ManyToMany(mappedBy = "roles")
    public List<UserBean> users = new ArrayList<UserBean>();

    @ManyToMany
    @JoinTable(
        name = "role_permission",
        joinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
        },
        inverseJoinColumns = {
            @JoinColumn(name = "permission_id", referencedColumnName = "id", nullable = false)
        }
    )
    public List<PermissionBean> permissions = new ArrayList<PermissionBean>();

    @Column(name = "description", length = 255)
    public String description;

    @Override
    public String getName() {
        return this.name;
    }

    public static RoleBean create (RoleBean role) {
        // when role exists, it can not be create success beacause of the uniqe name field. so return null.
        if (RoleBean.isExists(role)) return null;

        role.save();
        return role;
    }

    public static boolean isExists (RoleBean role) {
        if (role.id != null) return RoleBean.find.byId(role.id) != null;

        if (RoleBean.find.where().eq("name", role.name).findList().size() != 0) return true;

        return false;
    }

    public static final Finder<Long, RoleBean> find = new Finder<Long, RoleBean>(RoleBean.class);
}
