package com.dis.tmpdb.model.user;

import com.dis.tmpdb.model.base.AbstractModel;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "USER")
@ToString(callSuper = true)
public class User extends AbstractModel {

    @Column(name = "USERNAME", length = 50, unique = true)
    private String username;

    @Column(name = "PASSWORD", length = 100)
    private String password;

    @Column(name = "FIRSTNAME", length = 50)
    private String firstname;
    @Column(name = "LASTNAME", length = 50)
    private String lastname;
    @Column(name = "EMAIL", length = 50)
    private String email;
    @Column(name = "ENABLED")
    private boolean enabled;
    @Column(name = "LASTPASSWORDRESETDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordResetDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_ROLE",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})
    private List<Role> roles;

    public User() {

    }

    public User(String username, String password) {
        this();
        this.username = username;
        this.password = password;
    }
}
