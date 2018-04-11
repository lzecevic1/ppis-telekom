package ba.unsa.etf.ppis.telekom.controllers;

import ba.unsa.etf.ppis.telekom.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseController<M, S extends BaseService<M, ? >> {
    protected S service;

    @Autowired
    public void setService(S service) {
        this.service = service;
    }

    @ResponseBody
    public Collection<M> all() {
        return service.all();
    }

    @Transactional
    public ResponseEntity create(@RequestBody M model) {
        service.save(model);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Transactional
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity serviceExceptionHandler(Exception e) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("errorTitle", "Bad request");
        map.put("errorMessage", e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }
}