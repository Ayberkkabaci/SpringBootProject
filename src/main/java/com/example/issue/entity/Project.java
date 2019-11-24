package com.example.issue.entity;
import lombok.*;
import javax.persistence.*;
import java.util.Optional;

@Data
@NoArgsConstructor // nesnenin boş constructor unu yaratıyor
@AllArgsConstructor // bütün fieldleri kullanarak constructor yaratıyor.
@Entity
@EqualsAndHashCode // equals ve hashcode methodunu override ediyor.
@Table(name = "project")
@ToString
public class Project extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "project_name", length = 300)
    private String projectName;

    @Column(name = "project_code", length = 300)
    private String projectCode;

    @JoinColumn(name = "manager_user_id")
    @ManyToOne(optional = true ,fetch = FetchType.LAZY)
    private User Manager;
}
