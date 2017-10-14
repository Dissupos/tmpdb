package com.dis.tmpdb.model;

import com.dis.tmpdb.model.base.AbstractModel;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;

@Data
@Entity
@ToString(callSuper = true)
public class Template extends AbstractModel {

    private String name;
    private String template;

    public Template() {
        super();
    }

    public Template(String name, String template) {
        this();
        this.name = name;
        this.template = template;
    }
}
