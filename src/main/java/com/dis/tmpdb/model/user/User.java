package com.dis.tmpdb.model.user;

import com.dis.tmpdb.model.base.AbstractModel;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@ToString(callSuper = true)
public class User extends AbstractModel {

    private String username;

    private String password;

    @OneToMany
    private List<Role> roleList;

    public User() {

    }

    public User(String username, String password) {
        this();
        this.username = username;
        this.password = password;
    }
}
