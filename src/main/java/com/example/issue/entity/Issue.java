package com.example.issue.entity;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
@ToString
@Data
@NoArgsConstructor // nesnenin boş constructor unu yaratıyor
@AllArgsConstructor // bütün fieldleri kullanarak constructor yaratıyor.
@Entity
@EqualsAndHashCode // equals ve hashcode methodunu override ediyor.
@Table(name = "issue")

public class Issue extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description",length = 1000)
    private String description;

    @Column(name = "details", length = 4000)
    private String details;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "issue_status")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @JoinColumn(name = "assignee_user_id") // ilişkisel bir property tanımlıyorsan bunun columdaki ifadesi joincolumn dur
    @ManyToOne(optional = true,fetch = FetchType.LAZY) //bir çok issue bir user a bağlanabilir /lazy-> get ile istediğin zaman getirilir. Eager her zaman getirilir.
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Project project;
}
