package models;

import com.avaje.ebean.Model;
import javax.persistence.*;


/**
 * Created by Summer on 2016/2/11.
 */

@Entity
@Table(name = "User")
public class UserBean extends Model {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "username", length = 255, nullable = false, unique = true)
    public String name;

    @Column(name = "password_hash", length = 255, nullable = false)
    public String password_hash;

    @Column(name = "pen_name", length = 255, nullable = false, unique = true)
    public String pen_name;

    @Column(name = "avatar", length = 255)
    public String avatar;

    @Column(name = "introduce", length = 255)
    public String introduce;
}
