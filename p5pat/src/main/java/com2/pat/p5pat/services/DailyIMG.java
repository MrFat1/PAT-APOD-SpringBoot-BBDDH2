package com2.pat.p5pat.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface DailyIMG {

    ResponseEntity<String> getData();
}

