package com.cricket.cricket;

import com.cricket.cricket.Cricket;
import com.cricket.cricket.CricketService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping("/cricket")
@RestController

public class CricketController {
	
	private CricketService service;

    public CricketController(CricketService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Cricket> getPlayer(@PathVariable("id") Integer playerId) {
        return service.get(playerId);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Cricket updateCricket(@PathVariable("id") Integer playerId, @RequestBody Cricket cricket) {
        return service.update(playerId, cricket);
    }
    
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cricket> getAll() {
        return service.getAll();
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Cricket createCricket(@RequestBody Cricket cricket) {
        Cricket createdCricket = service.create(cricket);
        return createdCricket;
    }  
 
}
