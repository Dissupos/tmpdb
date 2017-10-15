package com.dis.tmpdb.web.resource.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TemplateForm {
    @NotNull(groups = { Exist.class })
    private String name;
    @NotNull(groups = { NotExist.class })
    private String template;

    public interface Exist {
    }

    public interface NotExist {
    }
}
