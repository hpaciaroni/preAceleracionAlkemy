package com.alkemy.icons.icons.controller;

import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class IconController {

    @Autowired
    IconService iconService;


    @PutMapping("/{id}")
    public ResponseEntity<IconDTO> update(@PathVariable Long id, @RequestBody IconDTO icon){
        IconDTO result = this.iconService.update(id,icon);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.iconService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}/pais/{idPais}")
    public ResponseEntity<Void> addPais(@PathVariable Long id, @PathVariable Long idPais){
        this.iconService.addPais(id,idPais);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/{id}/pais/{idPais}")
    public ResponseEntity<Void> removePais(@PathVariable Long id, @PathVariable Long idPais){
        this.iconService.removePais(id, idPais);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}


