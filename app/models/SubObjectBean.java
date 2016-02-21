package models;

import javax.persistence.*;

/**
 * Created by zh16437 on 2016/2/19.
 */

@Entity
@Table(name = "sub_object")
public class SubObjectBean {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "varchar(255) CHARACTER SET utf8 COLLATE utf8_bin")
    public String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "object_id", referencedColumnName = "id")
    public ObjectBean object = new ObjectBean();

    @ManyToOne(optional = false)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    public ItemBean item = new ItemBean();

    @ManyToOne(optional = false)
    @JoinColumn(name = "part_id", referencedColumnName = "id")
    public PartBean part = new PartBean();

    @Column(name = "description", length = 255)
    public String description;
}
