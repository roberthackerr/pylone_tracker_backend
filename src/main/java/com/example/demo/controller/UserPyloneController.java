package com.example.demo.controller;

import com.example.demo.model.Pylone;
import com.example.demo.service.PyloneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pylones")
@CrossOrigin(origins = "*") // autoriser Angular à appeler ce backend
public class UserPyloneController {

    @Autowired
    private PyloneService pyloneService;

    @GetMapping
    public List<Pylone> getAllPylones() {
        return pyloneService.getAllPylones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pylone> getPyloneById(@PathVariable Integer id) {
        return pyloneService.getPyloneById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pylone createPylone(@RequestBody Pylone pylone) {
        return pyloneService.createPylone(pylone);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pylone> updatePylone(@PathVariable Integer id, @RequestBody Pylone pylone) {
        try {
            return ResponseEntity.ok(pyloneService.updatePylone(id, pylone));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePylone(@PathVariable Integer id) {
        pyloneService.deletePylone(id);
        return ResponseEntity.noContent().build();
    }
}
