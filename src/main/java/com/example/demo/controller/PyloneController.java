package com.example.demo.controller;

import com.example.demo.model.Pylone;
import com.example.demo.service.PyloneService;

import jakarta.validation.Valid;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/admin")
public class PyloneController {

    @Autowired
    private PyloneService pyloneService;

    // Endpoint to add a new pylone
    @PostMapping("/pylone/x")
    public ResponseEntity<Pylone> addPylone(@Valid @RequestBody Pylone pylone) {
        Pylone createdPylone = pyloneService.createPylone(pylone);
        return ResponseEntity.ok(createdPylone);
    }
    @PostMapping("/pylone")
public ResponseEntity<?> addPyloneWithPhoto(
@RequestParam("photo") MultipartFile file,
@RequestParam("name") String name,
@RequestParam("description") String desc,
@RequestParam("latitude") Double lat,
@RequestParam("longitude")Double log,
@RequestParam("rsrp") Double rsrp,
@RequestParam("place") String place,
@RequestParam("rsrq") Double rsrq ) {
     // Optional: validate file type & size
     if (file.isEmpty()) {
        return ResponseEntity.badRequest().body(Map.of("error", "No file uploaded"));
    }
    // Example: save to disk (or convert to Base64 for DB)
    String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
    Path path = Paths.get("uploads/pylone/" + fileName);
    try {
        Files.write(path, file.getBytes());
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }
    
    Pylone pylone =Pylone.builder()
    .latitude(lat)
    .photo("uploads/pylone/"+fileName)
    .name(name)
    .longitude(log)
    .rsrp(rsrp)
    .place(place)
    .description(desc)
    .build();
    Pylone createdPylone = pyloneService.createPylone(pylone);
    return ResponseEntity.ok(createdPylone);
}

}
