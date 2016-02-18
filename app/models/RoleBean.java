package models;

import com.avaje.ebean.Model;
import javax.persistence.*;

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
}
