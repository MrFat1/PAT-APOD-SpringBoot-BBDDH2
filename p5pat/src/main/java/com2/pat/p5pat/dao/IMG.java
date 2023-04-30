package com2.pat.p5pat.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Table("IMG")
public class IMG {

    private @Column("PHOTO_ID") @Id
    Integer photo_id;
    private @Column("EARTH_DATE")
    Date earth_Date;
    private @Column("CAMERA_NAME")
    String camera_name;
    private @Column("IMG_SRC")
    String img_src;

    public Date getEarth_Date() {
        return earth_Date;
    }
    public String getCamera_name() {
        return camera_name;
    }
    public Integer getPhoto_id() {
        return photo_id;
    }
    public String getImg_src() {
        return img_src;
    }

    public void setEarth_Date(Date earth_date) {
        this.earth_Date = earth_date;
    }
    public void setCamera_name(String camera_name) {
        this.camera_name = camera_name;
    }
    public void setPhoto_id(Integer photo_id) {
        this.photo_id = photo_id;
    }
    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public IMG(Integer photo_id, Date earth_Date, String camera, String img_src) {
        this.earth_Date = earth_Date;
        this.camera_name = camera;
        this.photo_id = photo_id;
        this.img_src = img_src;

    }

    public IMG() {
        this.earth_Date = null;
        this.camera_name = "";
        this.photo_id = 0;
        this.img_src = "";

    }

    @Override
    public String toString() {
        return "Imágenes [Fecha=" + this.earth_Date + ", Camera_Name=" + this.camera_name + ", Photo_ID=" + this.photo_id + ", IMG_SRC=" + this.img_src + "]";
    }

}
