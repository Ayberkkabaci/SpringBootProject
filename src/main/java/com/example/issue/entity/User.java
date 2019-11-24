package com.example.issue.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor // nesnenin boş constructor unu yaratıyor
@AllArgsConstructor // bütün fieldleri kullanarak constructor yaratıyor.
@Entity
@EqualsAndHashCode // equals ve hashcode methodunu override ediyor.
@Table(name = "users")
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "uname",length = 100,unique = true)
    private String username;

    @JsonIgnore
    @Column(name = "pwd", length = 200)
    private  String password;

    @Column(name = "name_surname", length = 200)
    private  String nameSurname;

    @Column(name = "email", length = 100)
    private String email;

    @JoinColumn(name = "assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY) // bir tane issu ya bir çok user bağlanabilir.
    private List<Issue>issues;
}

