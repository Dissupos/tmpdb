package com.dis.tmpdb.service.server;

import com.dis.tmpdb.model.server.Server;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;

@Transactional
public interface ServerService {

    Page<Server> getByPage(Pageable pageable);

    Server getById(Long id);

    Server save(Server server);

    void remove(Server server);

}
