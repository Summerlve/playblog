package models;

import com.avaje.ebean.Model;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Created by Summer on 2016/2/11.
 */

@Entity
@Table(name = "user")
public class UserBean extends Model {
    @Id
    @Column(name = "id", length = 20, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "username", nullable = false, unique = true, columnDefinition = "varchar(255) CHARACTER SET utf8 COLLATE utf8_bin")
    public String username;

    @Column(name = "password_hash", length = 255, nullable = false)
    public String password_hash;

    @Column(name = "pen_name", nullable = false, unique = true, columnDefinition = "varchar(255) CHARACTER SET utf8 COLLATE utf8_bin")
    public String pen_name;

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

    public static final Finder<Long, UserBean> find = new Finder<Long, UserBean>(UserBean.class);
}
