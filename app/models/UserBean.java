package models;

import com.avaje.ebean.Model;
import javax.persistence.*;


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

    public static final Finder<Long, UserBean> find = new Finder<Long, UserBean>(Long.class, UserBean.class);
}
