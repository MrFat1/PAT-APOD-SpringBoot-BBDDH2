package com2.pat.p5pat.controler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com2.pat.p5pat.dao.IMG;
import com2.pat.p5pat.dto.IMGGallery;
import com2.pat.p5pat.services.MarsRober;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoberControler {

    Logger log = LoggerFactory.getLogger(RoberControler.class);

    @Autowired
    MarsRober mrs;

    @PostMapping(path = "/mrsRober",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> imgages(@RequestBody IMGGallery gallery) throws JsonProcessingException { //Creamos una clase IMGGallery con la info del formulario

        log.info("Objeto 'IMGGallery' generado con el POST: " + gallery.toString());

        return mrs.getGallery(gallery);
    }

    @GetMapping("/imagenes")
    public ResponseEntity<Iterable<IMG>> getImages(@RequestParam(required = false) String id) {
        Iterable<IMG> response = mrs.getImagenes();
        return ResponseEntity.ok().body(response);

    }

    @GetMapping("/saveGallery")
    public HttpStatus saveGallery() {
        return mrs.saveActualGallery();

    }

    @DeleteMapping("/clearTable")
    public void clearTable() {

        mrs.clearTable();
    }

    @DeleteMapping("/clearArray")
    public void clearArray() {

        mrs.clearArray();
    }

    @GetMapping("/mrsRober/{id}")
    public ResponseEntity<IMG> getIMG(@PathVariable Integer id) {

        if (id == null) {
            id = 0;
        }

        IMG response = mrs.getIMG(id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/mrsRober/{id}")
    public void updateIMG(@PathVariable Integer id) {
        if (id == null) {
            id = 0;
        }

        mrs.updateIMG(id);

    }

}
