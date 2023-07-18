package com.example.photoclone;

public class Photo {

    private String id;

    private String FileName;
    public Photo(){

    }
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
      id = id;
    }

}
