package com.dis.tmpdb.model.user;

import com.dis.tmpdb.model.base.AbstractModel;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@ToString(callSuper = true)
public class Role extends AbstractModel {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

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
