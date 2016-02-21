package models;

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
public class RoleBean extends Model {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "varchar(255) CHARACTER SET utf8 COLLATE utf8_bin")
    public String name;

    @ManyToMany(mappedBy = "roles")
    public List<UserBean> users = new ArrayList<UserBean>();

    @Column(name = "description", length = 255)
    public String description;

    public static RoleBean create (RoleBean role) {
        // when role exists, it can not be create success beacause of the uniqe name field. so return null.
        if (!RoleBean.isExists(role)) return null;

        role.save();
        return role;
    }

    public static boolean isExists (RoleBean role) {
        if (RoleBean.find.where().eq("name", role.name).findList().size() != 0) return true;
        else return false;
    }

    public static final Finder<Long, RoleBean> find = new Finder<Long, RoleBean>(RoleBean.class);
}
