package com2.pat.p5pat.Repository;

import com2.pat.p5pat.dao.IMG;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface IMGRepository extends CrudRepository<IMG, Integer> {

    @Modifying
    @Query("INSERT INTO IMG VALUES(:photo_id,:earth_date,:camera_name,:img_src)")
    int insertImage(
            @Param("photo_id") Integer photo_id,
            @Param("earth_date") Date earth_date,
            @Param("camera_name") String camera_name,
            @Param("img_src") String img_src);

    @Modifying
    @Query("DELETE FROM IMG")
    int clearTable();

    @Modifying
    @Query("UPDATE IMG SET EARTH_DATE = :earth_date, CAMERA_NAME = :camera_name, IMG_SRC = :img_src WHERE PHOTO_ID = :photo_id")
    int updateIMG(
      @Param("earth_date") Date earth_date,
      @Param("camera_name") String camera_name,
      @Param("img_src") String img_src,
      @Param("photo_id") Integer photo_id
    );

}

