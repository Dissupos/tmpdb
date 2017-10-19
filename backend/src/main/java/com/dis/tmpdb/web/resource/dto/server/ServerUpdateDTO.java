package com.dis.tmpdb.web.resource.dto.server;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class ServerUpdateDTO {
    private Boolean enabled;
    @Size(min = 3, max = 100)
    private String name;
    
    private String status;
}
