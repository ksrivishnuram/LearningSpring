package com.re5lect.sri.photos.clone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;

public class Photo {
    private String id;
//    marking as NotEmpty that incoming json fileName should not be empty
    @NotEmpty
    private String fileName;
    @JsonIgnore
    /*
    justIgnore does not send random alphabets to the browser when returning the data
     */
    private byte[] data;

    public Photo() {
    }
    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
