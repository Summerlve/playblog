package models;

import com.avaje.ebean.Model;

import javax.persistence.*;

/**
 * Created by Summer on 2016/2/11.
 */
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
}
