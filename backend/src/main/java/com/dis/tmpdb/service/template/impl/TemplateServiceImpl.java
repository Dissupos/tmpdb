package com.dis.tmpdb.service.template.impl;

import com.dis.tmpdb.model.Template;
import com.dis.tmpdb.repository.TemplateRepository;
import com.dis.tmpdb.service.template.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    private TemplateRepository repository;

    @Override
    public Page<Template> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
