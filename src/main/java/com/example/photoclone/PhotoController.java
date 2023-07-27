package com.example.photoclone;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class PhotoController{

    //    private List<Photo> db = List.of(new Photo("1", "hello.jpg"));

    private Map<String, Photo> db = new HashMap<>(){
        {
            put("1", new Photo("1", "Hello.jpg"));
        }
    };

    @GetMapping("/")
    public String Hello(){
        return "Hello World";
    }

    @GetMapping("/photos")
    public Collection<Photo> get(){
        System.out.println(db.values());
        return db.values();
    }

    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = db.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photo/{id}")
    public Photo delete(@PathVariable String id){
        Photo photo = db.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }
    @PostMapping("/photos/add")
    public Photo create(@RequestBody @Valid Photo photo){
        photo.setId(UUID.randomUUID().toString());
        db.put(photo.getId(), photo);
//        System.out.println(UUID.randomUUID().toString());
        return  photo;
    }
}
