package com2.pat.p5pat.dto;

public class IMGGallery {

    private String earth_date;
    private String camera;

    public IMGGallery(String earth_date, String camera) {
        this.earth_date = earth_date;
        this.camera = camera;
    }

    public String getEarth_date() {
        return this.earth_date;
    }

    public String getCamera() {
        return this.camera;
    }

    @Override
    public String toString() {
        return "Imágenes [earth_date=" + this.earth_date + ", camera=" + this.camera + "]";
    }
}
