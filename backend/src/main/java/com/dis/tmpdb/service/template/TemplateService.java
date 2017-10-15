package com.dis.tmpdb.service.template;

import com.dis.tmpdb.model.Template;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.transaction.Transactional;

@Transactional
public interface TemplateService {
    @PreAuthorize("hasRole('ADMIN')")
    Page<Template> getAll(Pageable pageable);

}
