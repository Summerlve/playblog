package models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zh16437 on 2016/2/19.
 */

@Entity
@Table(
    name = "star",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = { "star_to", "star_by_ip" })
    }
)
public class StarBean {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "star_to", referencedColumnName = "id")
    public ArticleBean article = new ArticleBean();

    @Column(name = "star_by_ip", nullable = false, columnDefinition = "INT(10) UNSIGNED NOT NULL")
    public String ip;

    @Column(name = "star_at")
    @Temporal(TemporalType.TIMESTAMP)
    public Date starAt;
}
