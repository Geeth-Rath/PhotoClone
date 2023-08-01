package com.example.photoclone.Service;

import com.example.photoclone.Model.Photo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class Photoservice {
    private Map<String, Photo> db = new HashMap<>(){
        {
            put("1", new Photo("1", "Hello.jpg"));
        }
    };

    public Collection<Photo> get() {
        return db.values();
    }
    public Photo get(String id) {
        return db.get(id);
    }

    public Photo remove(String id) {
        return db.remove(id);
    }

    public Photo save(String file, String contentType, byte [] data) {

        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(file);
        photo.setContentType(contentType);
        photo.setData(file.getBytes());
        db.put(photo.getId(), photo);
        return photo;

    }
}
