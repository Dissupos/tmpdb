package com.dis.tmpdb.model.server;

import com.dis.tmpdb.model.base.AbstractModel;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "SERVER")
@ToString(callSuper = true)
public class Server extends AbstractModel {
    @Column(name = "NAME", length = 100, nullable = false)
    private String name;
    @Column(name = "URL", length = 500, nullable = false)
    private String url;
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private ServerStatus status;
    @Column(name = "ENABLED", nullable = false)
    private boolean enabled = false;
    @Column(name = "LAST_SUCCESS_CHECK")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastSuccessCheck;
    @Column(name = "LAST_UNSUCCESS_CHECK")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUnsuccessCheck;


    public Server() {
        super();
    }

    public Server(String name, String url) {
        this();
        this.name = name;
        this.url = url;
    }

}
