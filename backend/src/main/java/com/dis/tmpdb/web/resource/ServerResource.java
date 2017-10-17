package com.dis.tmpdb.web.resource;

import com.dis.tmpdb.help.RestApiController;
import com.dis.tmpdb.model.server.Server;
import com.dis.tmpdb.service.server.ServerService;
import com.dis.tmpdb.web.resource.dto.server.ServerAddDTO;
import com.dis.tmpdb.web.resource.dto.server.ServerListDTO;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@RestApiController
public class ServerResource {

    private ServerService service;

    @Autowired
    public ServerResource(ServerService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/servers")
    public ResponseEntity<Page<ServerListDTO>> getServers(Pageable pageable) {
        val page = service.getByPage(pageable);
        return new ResponseEntity<>(page.map(entity -> {
            ServerListDTO dto = new ServerListDTO();
            dto.setName(entity.getName());
            dto.setLastSuccessCheck(entity.getLastSuccessCheck());
            dto.setLastUnsuccessCheck(entity.getLastUnSuccessCheck());
            dto.setEnabled(entity.isEnabled());
            return dto;
        }), HttpStatus.OK);
    }

    @PostMapping("/servers")
    public ResponseEntity<Server> addServer(@RequestBody @Valid ServerAddDTO dto) {
        return new ResponseEntity<>(service.save(new Server(dto.getName(), dto.getUrl())), HttpStatus.OK);
    }

}

