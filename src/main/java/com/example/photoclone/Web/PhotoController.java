package com.example.photoclone.Web;

import com.example.photoclone.Model.Photo;
import com.example.photoclone.Service.Photoservice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotoController{

    //    private List<Photo> db = List.of(new Photo("1", "hello.jpg"));
    private final Photoservice photoservice;

    public PhotoController(Photoservice photoservice) {
        this.photoservice = photoservice;
    }


    @GetMapping("/")
    public String Hello(){
        return "Hello World";
    }

    @GetMapping("/photos")
    public Collection<Photo> get(){
        return photoservice.get();
    }

    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = photoservice.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photo/{id}")
    public Photo delete(@PathVariable String id){
        Photo photo = photoservice.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }
    @PostMapping("/photos/add")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        return photoservice.save(file.getOriginalFilename(),file.getContentType(), file.getBytes());

    }
}
