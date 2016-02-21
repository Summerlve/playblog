package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Summer on 2016/2/13.
 */

@Entity
@Table(name = "operation")
public class OperationBean extends Model {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "varchar(255) CHARACTER SET utf8 COLLATE utf8_bin")
    public String name;

    @OneToMany(mappedBy = "operation")
    public List<PermissionBean> permissions = new ArrayList<PermissionBean>();

    @Column(name = "description", length = 255)
    public String description;
}
