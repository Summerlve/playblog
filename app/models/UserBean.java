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
    @Column(name="id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="name", length = 255, nullable = false, unique = true, )
    public String name;


}
