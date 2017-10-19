package com.dis.tmpdb.web.resource.dto.server;

import com.dis.tmpdb.model.server.ServerStatus;
import lombok.Data;

import java.util.Date;

@Data
public class ServerListDTO {
    private Long id;
    private String name;
    private ServerStatus status;
    private Date lastSuccessCheck;
    private Date lastUnsuccessCheck;
    private boolean enabled;
}
