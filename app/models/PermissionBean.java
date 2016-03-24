package models;

import be.objectify.deadbolt.core.models.Permission;
import com.avaje.ebean.Model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Summer on 2016/2/13.
 */

@Entity
@Table(name = "permission")
public class PermissionBean extends Model implements Permission {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "varchar(255) CHARACTER SET utf8 COLLATE utf8_bin")
    public String name;

    @ManyToMany(mappedBy = "permissions")
    public List<RoleBean> roles = new ArrayList<RoleBean>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "operation_id", referencedColumnName = "id")
    public OperationBean operation = new OperationBean();

    @ManyToOne(optional = false)
    @JoinColumn(name = "sub_object_id", referencedColumnName = "id")
    public SubObjectBean subObject = new SubObjectBean();

    @Column(name = "description", length = 255)
    public String description;

    @Override
    public String getValue() {
        return this.name;
    }

    public static final Finder<Long, PermissionBean> find = new Finder<Long, PermissionBean>(PermissionBean.class);
}
