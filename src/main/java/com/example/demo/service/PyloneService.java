package com.example.demo.service;

import com.example.demo.model.Pylone;
import com.example.demo.repo.PyloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PyloneService {

    @Autowired
    private PyloneRepository pyloneRepository;

    public List<Pylone> getAllPylones() {
        return pyloneRepository.findAll();
    }

    public Optional<Pylone> getPyloneById(Integer id) {
        return pyloneRepository.findById(Integer.toUnsignedLong(id));
    }

    public Pylone createPylone(Pylone pylone) {
        return pyloneRepository.save(pylone);
    }

    public Pylone updatePylone(Integer id, Pylone updatedPylone) {
        return pyloneRepository.findById(Integer.toUnsignedLong(id)).map(p -> {
            p.setName(updatedPylone.getName());
            p.setDescription(updatedPylone.getDescription());
            p.setPlace(updatedPylone.getPlace());
            p.setLatitude(updatedPylone.getLatitude());
            p.setLongitude(updatedPylone.getLongitude());
            p.setRsrp(updatedPylone.getRsrp());
            p.setRsrq(updatedPylone.getRsrq());
            p.setPhoto(updatedPylone.getPhoto());
            return pyloneRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Pylone not found with id " + id));
    }

    public void deletePylone(Integer id) {
        pyloneRepository.deleteById(Integer.toUnsignedLong(id));
    }
}
