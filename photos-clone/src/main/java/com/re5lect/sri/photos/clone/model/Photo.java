package com.re5lect.sri.photos.clone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/*
mark the java class with database
Table Uppercase: h2 converts every table to upperCase by default
 */

@Table("PHOTOS")
public class Photo {
    @Id
    private Integer id;
//    marking as NotEmpty that incoming json fileName should not be empty
    @NotEmpty
    private String fileName;
    private String contentType;
    /*
    justIgnore does not send random alphabets to the browser when returning the data
     */
    @JsonIgnore
    private byte[] data;

    public Photo() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
