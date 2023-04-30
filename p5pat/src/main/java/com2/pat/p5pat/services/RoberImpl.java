package com2.pat.p5pat.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com2.pat.p5pat.Repository.IMGRepository;
import com2.pat.p5pat.dao.IMG;
import com2.pat.p5pat.dto.IMGGallery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;

@Service
public class RoberImpl implements MarsRober{

    private String key =  "&api_key=jhGISIlXsL9Xw2d93pdklkpvOc9TUKjPJGyTaB6M";

    Logger log = LoggerFactory.getLogger(RoberImpl.class);

    @Autowired
    IMGRepository imgRepository;

    ArrayList<IMG> images = new ArrayList<>();
    //ArrayList temporal para llevar un recuento de las imagenes dispuestas actualmente en la galería (No las guardadas
    //en la base de datos)

    @Override
    public ResponseEntity<String> getGallery(IMGGallery gallery) throws JsonProcessingException {

        log.info("===================== Obteniendo imagenes del Mars Rober ===================");

        String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date=" + gallery.getEarth_date() + "&camera=" + gallery.getCamera() + key;

        log.info("Url completo: " + url);

        log.info("LLamando a la API...");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);

        log.info("Status code: " + result.getStatusCode());

        try {
            addIMG(result.getBody()); //Añadimos la imagen al arrayList temporal
        } catch (ParseException e) {
            e.printStackTrace();
        }

        log.info("Objeto devuelto: " + result.getBody());

        return  result;


    }

    public ResponseEntity<String> checkData(IMGGallery gallery) {


        String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date=" + gallery.getEarth_date() + "&camera=" + gallery.getCamera() + key;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);

        return  result;

    }

    @Override
    public IMG getIMG(Integer id) {

        Optional<IMG> data = imgRepository.findById(id); //Select
        IMG img;

        if (data.isPresent())
            img = new IMG(data.get().getPhoto_id(), data.get().getEarth_Date(), data.get().getCamera_name(), data.get().getImg_src());
        else
            img = new IMG(0,null, "", "");


        return img;

    }

    /**
     * Este método añade las imágenes al ArrayList donde se guardan las imagenes dispuestas en la interfaz
     * @param body
     * @throws JsonProcessingException
     * @throws ParseException
     */
    public void addIMG(String body) throws JsonProcessingException, ParseException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(body);
        JsonNode name = root.path("photos");

        IMG img;

        for (Iterator<JsonNode> it = name.elements(); it.hasNext(); ) {

            JsonNode n = it.next();
            Date earth_date = new SimpleDateFormat("yyyy-MM-dd").parse(n.get("earth_date").asText());
            img = new IMG(n.get("id").asInt(), earth_date, n.get("camera").get("full_name").asText(), n.get("img_src").asText());

            images.add(img);

            log.info("Nueva imagen añadida al Array " + img);

        }
    }

    @Override
    public void updateIMG(Integer id) {

    }

    /**
     * Obtiene una lista con las imágenes actuales en la base de datos
     * @return
     */
    @Override
    public Iterable<IMG> getImagenes() {
        return imgRepository.findAll();
    }

    /**
     * Método para guardar la galería actual en la base de datos
     */
    @Override
    public HttpStatus saveActualGallery() {

        log.info("Añadiendo imágenes obtenidas a la tabla IMG...");

        if (images.isEmpty()) {
            log.info("Galería vacía, nada que guardar");
            return HttpStatus.NOT_FOUND;
        } else {
            for (IMG img : images) {

                //SI no existe ya en la tabla de imagenes
                if (!(imgRepository.existsById(img.getPhoto_id()))) {
                    imgRepository.insertImage(img.getPhoto_id(), img.getEarth_Date(), img.getCamera_name(), img.getImg_src());
                    log.info("Objeto añadido a la base de datos: " + img.toString());

                } else { //UPDATE

                    imgRepository.updateIMG(img.getEarth_Date(), img.getCamera_name(), img.getImg_src(), img.getPhoto_id());
                    log.info("Galería actualizada");

                }
            }

            return HttpStatus.OK;
        }
    }

    @Override
    public void clearArray() {
        images.clear();
        log.info("Se ha vacíado el array");
    }

    /**
     * Borra la información de la tabla
     */
    @Override
    public void clearTable() {

        log.info("Se ha borrado toda la información de la tabla.");
        imgRepository.clearTable();


    }

}
