package com.dis.tmpdb.repository.server;

import com.dis.tmpdb.model.server.Server;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerRepository extends PagingAndSortingRepository<Server, Long> {
}
