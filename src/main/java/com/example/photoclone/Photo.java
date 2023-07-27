package com.example.photoclone;

import jakarta.validation.constraints.NotEmpty;

public class Photo {

    private String id;
    @NotEmpty
    private String FileName;

    public Photo(){ }

    public  Photo(String id, String FileName){
        this.id = id;
        this.FileName = FileName;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public String getId(){
        return id;
    }

    public void setId(String Id){

        id = Id;
        System.out.println(id);
    }

}


//(async function AddPhoto(){
//
//        let Photo = {"fileName": "geethma.jpg"};
//
//
//        await fetch ('http://localhost:8080/photos/add', {
//
//        method:'POST',
//
//        headers:{
//        Accept:'application/json',
//        'Content-Type' : 'application/json',
//        },
//
//        body: JSON.stringify(Photo)})
//        .then( result => result.text ())
//        .then ( text => alert (text));
//        })();