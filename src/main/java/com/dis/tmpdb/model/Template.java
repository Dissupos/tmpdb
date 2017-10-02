package com.dis.tmpdb.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Template {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String template;

    public Template() {
    }

    public Template(String name, String template) {
        this.name = name;
        this.template = template;
    }
}
