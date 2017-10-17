package com.dis.tmpdb.web.resource.dto.server;

import lombok.Data;

import java.util.Date;

@Data
public class ServerListDTO {
    private String name;
    private Date lastSuccessCheck;
    private Date lastUnsuccessCheck;
    private boolean enabled;
}
