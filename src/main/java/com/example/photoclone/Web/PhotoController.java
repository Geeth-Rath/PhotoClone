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

    private final Photoservice photozService;

    public PhotoController(Photoservice photozService) {
        this.photozService = photozService;
    }

    @GetMapping("/")
    public String hello() {
        System.out.println("**********************");
        return "Hello World";
    }

    @GetMapping("/photoz")
    public Iterable<Photo> get() {
        System.out.println("######################");
        System.out.println(photozService.get());
        return photozService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable Integer id) {
        Photo photo = photozService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable Integer id) {
        photozService.remove(id);
    }

    @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        System.out.println("sssssssssssssssaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvveeeeeeee");
        return photozService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
}
