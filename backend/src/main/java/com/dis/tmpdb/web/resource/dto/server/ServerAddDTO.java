package com.dis.tmpdb.web.resource.dto.server;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ServerAddDTO {

    @NotNull
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    @Size(min = 10, max = 500)
    private String url;


    public ServerAddDTO() {

    }
}