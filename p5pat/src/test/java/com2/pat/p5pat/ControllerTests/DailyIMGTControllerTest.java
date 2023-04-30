package com2.pat.p5pat.ControllerTests;

import com2.pat.p5pat.services.DailyIMG;
import com2.pat.p5pat.services.DailyIMGImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class DailyIMGTControllerTest {

    @Autowired
    DailyIMGImpl dimpl = new DailyIMGImpl();

    @Test
    public void CheckStatusCodeDailyIMG() {

        Assertions.assertEquals(dimpl.checkData().getStatusCode(), HttpStatus.OK);

    }


}
