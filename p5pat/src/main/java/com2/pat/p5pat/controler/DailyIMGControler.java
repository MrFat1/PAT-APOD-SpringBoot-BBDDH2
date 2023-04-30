package com2.pat.p5pat.controler;

import com2.pat.p5pat.services.DailyIMG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DailyIMGControler {

    @Autowired
    private DailyIMG dimg;

    @GetMapping("/dailyIMG")
    public ResponseEntity<String> apiCall() {

        return dimg.getData();
    }

}
