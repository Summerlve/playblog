package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Summer on 2016/2/11.
 */

@Entity
@Table(name = "tag")
public class TagBean extends Model {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "varchar(255) CHARACTER SET utf8 COLLATE utf8_bin")
    public String name;

    @ManyToOne
    @JoinColumn(name = "create_by")
    public UserBean creater;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar createAt;

    @ManyToOne
    @JoinColumn(name = "update_by")
    public UserBean updater;

    @Column(name = "update_at")
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar updateAt;

    @OneToMany(mappedBy = "tag")
    public List<ArticleBean> articles = new ArrayList<ArticleBean>();

    public static final Finder<Long, TagBean> find = new Finder<Long, TagBean>(TagBean.class);
}
