package com.dis.tmpdb.repository;

import com.dis.tmpdb.model.Template;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends PagingAndSortingRepository<Template, Long> {
}
