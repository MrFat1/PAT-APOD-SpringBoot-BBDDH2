package com2.pat.p5pat.ControllerTests;

import com2.pat.p5pat.dto.IMGGallery;
import com2.pat.p5pat.services.RoberImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class RoberControllerTest {

    @Autowired
    RoberImpl impl = new RoberImpl();

    @Autowired
    IMGGallery imgGallery;
    IMGGallery imgGalleryBadArguments;

    @Before
    public void setUp() {
        imgGallery = new IMGGallery("2015-06-03", "FHAZ");
        imgGalleryBadArguments = new IMGGallery("2015/06/03", "FHAZ");

    }

    public HttpStatus CheckEarthDate(String date) {
        try {
            Date earth_date = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            return HttpStatus.OK;
        } catch(ParseException e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @Test
    public void checkCodeEarthDate() {
        assertEquals(HttpStatus.OK, CheckEarthDate(imgGallery.getEarth_date()));
        assertEquals(HttpStatus.BAD_REQUEST, CheckEarthDate(imgGalleryBadArguments.getEarth_date()));
    }

    @Test
    public void checkStatusCodeGoodRequest() {
        assertEquals(HttpStatus.OK, impl.checkData(imgGallery).getStatusCode());
    }

    @Test
    public void checkStatusCodeBadRequest() {
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, impl.checkData(imgGalleryBadArguments).getStatusCode());

    }

}
