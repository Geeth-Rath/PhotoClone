package com.example.photoclone;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        System.out.println(db);
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
}
