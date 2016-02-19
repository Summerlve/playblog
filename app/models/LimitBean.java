package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Summer on 2016/2/13.
 */
public class LimitBean extends Model {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToMany(mappedBy = "limit")
    public List<SubObjectBean> subObjects = new ArrayList<SubObjectBean>();

    @Column(name = "description", length = 255)
    public String description;
}
