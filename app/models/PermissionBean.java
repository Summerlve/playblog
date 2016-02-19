package models;

import com.avaje.ebean.Model;
import jdk.internal.instrumentation.TypeMappings;
import play.data.validation.Constraints;
import models.SubObjectBean;
import javax.persistence.*;

/**
 * Created by Summer on 2016/2/13.
 */
public class PermissionBean extends Model {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Constraints.Required
    @Column(name = "name", nullable = false, unique = true, columnDefinition = "varchar(255) CHARACTER SET utf8 COLLATE utf8_bin")
    public String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "operation_id", referencedColumnName = "id")
    public OperationBean operation = new OperationBean();

    @ManyToOne(optional = false)
    @JoinColumn(name = "sub_object_id", referencedColumnName = "id")
    public SubObjectBean subObject = new SubObjectBean();

    @Column(name = "description", length = 255)
    public String description;
}
