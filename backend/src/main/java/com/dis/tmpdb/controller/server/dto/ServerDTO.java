package com.dis.tmpdb.controller.server.dto;

import com.dis.tmpdb.model.server.ServerStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class ServerDTO {

    @NotNull(groups = NotExist.class)
    @Size(min = 3, max = 100)
    private String name;
    @NotNull(groups = NotExist.class)
    @Size(min = 10, max = 500)
    private String url;

    // Only for get requests
    @Null(groups = {Exist.class, NotExist.class})
    private Long id;
    @Null(groups = {Exist.class, NotExist.class})
    private ServerStatus status;
    @Null(groups = {Exist.class, NotExist.class})
    private Boolean enabled;
    @Null(groups = {Exist.class, NotExist.class})
    private Date lastSuccessCheck;
    @Null(groups = {Exist.class, NotExist.class})
    private Date lastUnsuccessCheck;

    interface Exist {
    }

    interface NotExist {
    }
}
