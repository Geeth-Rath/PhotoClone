package com.example.photoclone.Service;

import com.example.photoclone.Model.Photo;
import com.example.photoclone.Repository.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class Photoservice {
//    private Map<String, Photo> db = new HashMap<>(){
//        {
//            put("1", new Photo("1", "Hello.jpg"));
//        }
//    };

    private final PhotoRepository photoRepository;

    public Photoservice(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Iterable<Photo> get() {
        return photoRepository.findAll();
    }
    public Photo get(Integer id) {
        return photoRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
         photoRepository.deleteById(id);
    }

//    public Photo save(String file, String contentType, byte [] data) {
//        System.out.print("11111111111111");
//        Photo photo = new Photo();
//        System.out.print("2222222222222222");
//        photo.setFileName(file);
//        System.out.print("33333333333");
//        photo.setContentType(contentType);
//        System.out.print("444444444444444");
//        photo.setData(data);
//        System.out.print(file);
//        photoRepository.save(photo);
//        System.out.print("6666666666666666666");
//        return photo;
//
//    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
        System.out.print("6666666666666666666");
        photoRepository.save(photo);
        System.out.print("5555555555");
        return photo;
    }
}
