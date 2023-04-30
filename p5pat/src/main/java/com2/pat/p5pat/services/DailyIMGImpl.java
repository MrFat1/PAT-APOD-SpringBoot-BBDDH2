package com2.pat.p5pat.services;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DailyIMGImpl implements DailyIMG{

    private String key = "https://api.nasa.gov/planetary/apod?api_key=jhGISIlXsL9Xw2d93pdklkpvOc9TUKjPJGyTaB6M";

    Logger log = LoggerFactory.getLogger(DailyIMGImpl.class);

    @Override
    public ResponseEntity<String> getData() {

        log.info("=============== Obteniendo imagen/video diaria ===================");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> o = restTemplate.getForEntity(key, String.class);

        log.info("Status code: " + o.getStatusCode());

        log.info("Objecto devuelto: " + o.getBody());

        return o;
    }

    public ResponseEntity<String> checkData() {

        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<String> response = testRestTemplate.getForEntity(key, String.class);

        return response;
    }
}
