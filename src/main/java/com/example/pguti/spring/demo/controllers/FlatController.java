package com.example.pguti.spring.demo.controllers;

import com.example.pguti.spring.demo.entity.Flat;
import com.example.pguti.spring.demo.services.FlatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/flats")
public class FlatController {
    @Autowired
    private FlatService flatService;

    @PostMapping()
    public void save(@RequestBody Flat flat) {
        log.info("Create new flat: {}", flat);
        flatService.save(flat);
    }

    @GetMapping()
    public List<Flat> getAllFlats() {
        return flatService.getAll();
    }

    @GetMapping("/{id}")
    public Flat getFlatById(@PathVariable Long id) {
        return flatService.getFlatById(id);
    }

    @PutMapping("/{id}")
    public Flat updateFlatById(@PathVariable Long id, @RequestBody Flat flat) {
        return flatService.updateFlatById(id, flat);
    }

    @DeleteMapping("/{id}")
    public void deleteFlatById(@PathVariable Long id) {
        flatService.deleteFlatById(id);
    }

    @GetMapping("/retry2")
    public String testRetry2(@RequestParam("retry") boolean retry) {
        return flatService.testRetry2(retry);
    }

    @GetMapping("/retry")
    public String testRetry(@RequestParam("retry") boolean retry) {
        return flatService.testRetry(retry);
    }
}
