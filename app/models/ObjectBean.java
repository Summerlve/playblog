package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Summer on 2016/2/13.
 */

@Entity
@Table(name = "object")
public class ObjectBean extends Model {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToMany(mappedBy = "object", cascade = CascadeType.ALL)
    public List<SubObjectBean> subObjects = new ArrayList<SubObjectBean>();

    @Column(name = "description", length = 255)
    public String description;
}
