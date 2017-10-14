package com.dis.tmpdb.web.resource;

import com.dis.tmpdb.help.RestApiController;
import com.dis.tmpdb.model.Template;
import com.dis.tmpdb.repository.TemplateRepository;
import com.dis.tmpdb.web.resource.form.TemplateForm;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestApiController
public class TemplateResource {

    private TemplateRepository repo;

    @Autowired
    public TemplateResource(TemplateRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(value = "/template", method = RequestMethod.GET)
    public ResponseEntity<Page<Template>> findAll(Pageable pageable) {
        return new ResponseEntity<>(repo.findAll(pageable), HttpStatus.OK);
    }

    @RequestMapping(value = "/template/{id}", method = RequestMethod.GET)
    public ResponseEntity<Template> getById(@PathVariable Long id) {
        return new ResponseEntity<>(repo.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/template", method = RequestMethod.POST)
    public ResponseEntity<Template> create(@Validated(TemplateForm.NotExist.class) @RequestBody TemplateForm form) {
        return new ResponseEntity<>(repo.save(new Template(form.getName(), form.getTemplate())), HttpStatus.OK);
    }

    @RequestMapping(value = "/template/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Template> edit(
            @PathVariable Long id, @Validated(TemplateForm.Exist.class) @RequestBody TemplateForm form) {
        val template = repo.findOne(id);
        if (form.getName() != null) {
            template.setName(form.getName());
        }
        if (form.getTemplate() != null) {
            template.setTemplate(form.getTemplate());
        }
        return new ResponseEntity<>(repo.save(template), HttpStatus.OK);
    }

}
