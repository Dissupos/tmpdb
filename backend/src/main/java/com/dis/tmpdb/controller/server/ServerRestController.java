package com.dis.tmpdb.controller.server;

import com.dis.tmpdb.controller.server.dto.ServerDTO;
import com.dis.tmpdb.controller.server.dto.ServerListDTO;
import com.dis.tmpdb.help.RestApiController;
import com.dis.tmpdb.model.server.Server;
import com.dis.tmpdb.service.server.ServerService;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestApiController
public class ServerRestController {

    private ServerService service;

    @Autowired
    public ServerRestController(ServerService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/servers")
    public ResponseEntity<Page<ServerListDTO>> getServers(Pageable pageable) {
        val page = service.getByPage(pageable);
        return ResponseEntity.ok(page.map(entity -> {
            ModelMapper modelMapper = new ModelMapper();
            ServerListDTO dto = modelMapper.map(entity, ServerListDTO.class);
            return dto;
        }));
    }

    @PostMapping("/servers")
    public ResponseEntity<ServerDTO> addServer(@RequestBody @Valid ServerDTO dto) {
        ModelMapper mapper = new ModelMapper();
        val server = service.save(new Server(dto.getName(), dto.getUrl()));
        return ResponseEntity.ok(mapper.map(server, ServerDTO.class));
    }

    @PutMapping("/servers/{id}")
    public ResponseEntity<ServerDTO> updateServer(@PathVariable Long id, @RequestBody @Valid ServerDTO dto) {
        Server server = service.getById(id);

        if (server == null) {
            return ResponseEntity.notFound().build();
        }

        if (dto.getName() != null) {
            server.setEnabled(dto.getEnabled());
        }

        server.setLastSuccessCheck(new Date());
        server.setLastUnsuccessCheck(new Date());
        server = service.save(server);
        ModelMapper mapper = new ModelMapper();
        return ResponseEntity.ok(mapper.map(server, ServerDTO.class));
    }

    @GetMapping("/servers/{id}")
    public ResponseEntity<ServerDTO> getServer(@PathVariable Long id) {
        Server server = service.getById(id);

        if (server == null) {
            return ResponseEntity.notFound().build();
        }
        ModelMapper mapper = new ModelMapper();
        return ResponseEntity.ok(mapper.map(server, ServerDTO.class));
    }

}

