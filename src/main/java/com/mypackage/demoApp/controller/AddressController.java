package com.mypackage.demoApp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mypackage.demoApp.exception.ResourceNotFoundException;
import com.mypackage.demoApp.model.Address;
import com.mypackage.demoApp.model.Employee;
import com.mypackage.demoApp.repository.addressRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;





@RequestMapping("/api/v1/addresses")
@RestController
public class AddressController {

    @Autowired
    private addressRepository addressRepo;

    @GetMapping("")
    public List<Address> getAllAddress() {
        return addressRepo.findAll();
    }

    @PostMapping("")
    public Address createAddress(@RequestBody @Valid Address address) {
        return addressRepo.save(address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address addressBody) {
        Address address= addressRepo.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("Address not found"+id));
        address.setCity(address.getCity());
        address.setCountry(addressBody.getCountry());
        address.setStreet(addressBody.getStreet());
        Address newAddress = addressRepo.save(address);
        return ResponseEntity.ok(newAddress);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getSingleAddress(@PathVariable Long id) {
        Address address= addressRepo.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("Address not found"+id));
        return ResponseEntity.ok(address);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteAddress(@PathVariable Long id) {
        Address address= addressRepo.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("Address not found"+id));
        addressRepo.delete(address);
        Map<String,Boolean> response =new HashMap<>();
        response.put("address got deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    
    
    
    

    
}
