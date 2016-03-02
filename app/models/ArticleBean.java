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
@Table(name = "article")
public class ArticleBean extends Model {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "title", nullable = false, unique = true, columnDefinition = "varchar(255) CHARACTER SET utf8 COLLATE utf8_bin")
    public String title;

    @ManyToOne
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    public TagBean tag;

    @Lob
    @Column(name = "content")
    public String text;

    @ManyToOne(optional = false)
    @JoinColumn(name = "create_by", referencedColumnName = "id")
    public UserBean creater;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar createAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "update_by", referencedColumnName = "id")
    public UserBean updater;

    @Column(name = "update_at")
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar updateAt;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    public List<StarBean> stars = new ArrayList<StarBean>();

    public static ArticleBean create (ArticleBean article, UserBean user, TagBean tag) {
        // when user exists, it can not be create success beacause of the uniqe username field. so return null.
        if (!UserBean.isExists(user)) return null;

        try {
            tag = TagBean.queryOrCreate(tag);
            article.creater = user;
            article.tag = tag;
            article.save();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return article;
    }

    public static final Finder<Long, ArticleBean> find = new Finder<Long, ArticleBean>(ArticleBean.class);
}
