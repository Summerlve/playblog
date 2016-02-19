package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zh16437 on 2016/2/19.
 */
public class RangeBean {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToMany(mappedBy = "range")
    public List<SubObjectBean> subObjects = new ArrayList<SubObjectBean>();

    @Column(name = "description", length = 255)
    public String description;
}
