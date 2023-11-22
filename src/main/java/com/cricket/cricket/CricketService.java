package com.cricket.cricket;

import com.cricket.cricket.Cricket;
import com.cricket.cricket.CricketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CricketService {
	
	@Autowired
	 private CricketRepository repository;
	 
	 public CricketService() {
		 this.repository = repository;
	 }
	 
	 public Cricket create(Cricket cricket) {
		 return repository.save(cricket);
	 }
	 
	 public Optional<Cricket> get(Integer playerID) {
		 Optional<Cricket> cricket = repository.findById(playerID);
		 return cricket;
		 
	 }
	 
	 public List<Cricket> getAll(){
		 List<Cricket> crickets = null;
	        try {
	            crickets = repository.findAll();
	        } catch (Exception e) {
	            System.out.println("STackTrace: " + Arrays.toString(e.getStackTrace()));
	            System.out.println("Caught an Exception....");
	            crickets = new ArrayList<>();
	        }
	        return crickets;
	    }
	 
	 public Cricket update(Integer playerID, Cricket cricket) {
	        if (playerID != cricket.getPlayerId()) {
	            //throw new CricketValidationException("Mismatch in playerID");
	        }
	        Optional<Cricket> cricketOptional = repository.findById(playerID);
	        if (cricketOptional.isPresent()) {
	            return repository.save(cricket);
	        }
	        else {
	            //throw new CricketNotFoundException("Cricket Not found: " + playerID);
	        	return null;
	        }
	    
	 }

}