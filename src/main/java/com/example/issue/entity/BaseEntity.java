package com.example.issue.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Data //Getter ve setter metodlarını sağlıyor. lombok ile geldiğini import.lombok.data dan anlayabiliriz.
@MappedSuperclass //bütün tablolarda ortak olmayı sağlayan annotation
public abstract class BaseEntity implements Serializable {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_At")
    private Date createdAt;

    @Column(name = "created_By", length = 100)
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_At")
    private Date updateAt;

    @Column(name = "updated_By")
    private String updatedBy;

    @Column(name = "status")
    private boolean status = true;

}
