package com.example.photoclone.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("Photos")
public class Photo {
    @Id
    private Integer id;
    @NotEmpty
    private String FileName;

    @JsonIgnore
    private byte[] data; // contains photo data

    private String ContentType;



    public Photo(){ }

    public  Photo(Integer id, String FileName){
        this.id = id;
        this.FileName = FileName;
    }




    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer Id){

        id = Id;
        System.out.println(id);
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getContentType() {
        return ContentType;
    }

    public void setContentType(String contentType) {
        ContentType = contentType;
    }
}
