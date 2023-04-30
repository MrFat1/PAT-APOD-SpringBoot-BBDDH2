package com2.pat.p5pat.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com2.pat.p5pat.dao.IMG;
import com2.pat.p5pat.dto.IMGGallery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public interface MarsRober {

    ResponseEntity<String> getGallery(IMGGallery gallery) throws JsonProcessingException; //Mandamos el formulario al impl
    IMG getIMG(Integer id);
    //void CreateTable(String body) throws JsonProcessingException, ParseException;
    void clearTable();
    void updateIMG(Integer id);
    Iterable<IMG> getImagenes();
    HttpStatus saveActualGallery();
    void clearArray();

}
