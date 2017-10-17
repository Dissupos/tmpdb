package com.dis.tmpdb.service.server.impl;

import com.dis.tmpdb.model.server.Server;
import com.dis.tmpdb.repository.server.ServerRepository;
import com.dis.tmpdb.service.server.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServerServiceImpl implements ServerService {

    private ServerRepository repository;

    @Autowired
    public ServerServiceImpl(ServerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Server> getByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Server getById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Server save(Server server) {
        return repository.save(server);
    }

    @Override
    public void remove(Server server) {
        repository.delete(server);
    }
}
