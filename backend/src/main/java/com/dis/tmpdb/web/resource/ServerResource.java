package com.dis.tmpdb.web.resource;

import com.dis.tmpdb.help.RestApiController;
import com.dis.tmpdb.model.server.Server;
import com.dis.tmpdb.model.server.ServerStatus;
import com.dis.tmpdb.service.server.ServerService;
import com.dis.tmpdb.web.resource.dto.server.ServerAddDTO;
import com.dis.tmpdb.web.resource.dto.server.ServerListDTO;
import com.dis.tmpdb.web.resource.dto.server.ServerUpdateDTO;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

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

        return ResponseEntity.ok(page.map(entity -> {
            ServerListDTO dto = new ServerListDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setLastSuccessCheck(entity.getLastSuccessCheck());
            dto.setLastUnsuccessCheck(entity.getLastUnSuccessCheck());
            dto.setEnabled(entity.isEnabled());
            dto.setStatus(entity.getStatus());
            return dto;
        }));
    }

    @PostMapping("/servers")
    public ResponseEntity<Server> addServer(@RequestBody @Valid ServerAddDTO dto) {
        return ResponseEntity.ok(service.save(new Server(dto.getName(), dto.getUrl())));
    }

    @PutMapping("/servers/{id}")
    public ResponseEntity<Server> updateServer(@PathVariable Long id, @RequestBody @Valid ServerUpdateDTO dto) {
        Server server = service.getById(id);

        if (dto.getName() != null) {
            server.setEnabled(dto.getEnabled());
        }
        if (dto.getEnabled() != null) {
            server.setName(dto.getName());
        }
        if(dto.getStatus() != null) {
            server.setStatus(ServerStatus.valueOf(dto.getStatus()));
        }
        server.setLastSuccessCheck(new Date());
        server.setLastUnSuccessCheck(new Date());
        return ResponseEntity.ok(service.save(server));
    }

}

