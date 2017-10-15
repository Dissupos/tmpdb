package com.dis.tmpdb.model.user;

import com.dis.tmpdb.model.base.AbstractModel;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "ROLE")
@ToString(callSuper = true)
public class Role extends AbstractModel {

    @Column(name = "NAME", length = 50)
    private String name;
    @Column(name = "DESCRIPTION", length = 200)
    private String description;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;

    public Role() {
    }

    public Role(String name) {
        this();
        this.name = name;
    }

    public Role(String name, String description) {
        this(name);
        this.description = description;
    }
}
