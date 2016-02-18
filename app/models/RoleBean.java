package models;

import com.avaje.ebean.Model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Summer on 2016/2/11.
 */

@Entity
@Table(name = "role")
public class RoleBean extends Model {
    @Id
    @Column(name = "id", length = 20, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "varchar(255) CHARACTER SET utf8 COLLATE utf8_bin")
    public String name;

    @ManyToMany(mappedBy = "roles")
    public List<UserBean> users = new ArrayList<UserBean>();

    public static final Finder<Long, RoleBean> find = new Finder<Long, RoleBean>(RoleBean.class);
}
