package com.mypackage.demoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypackage.demoApp.model.Address;

public interface addressRepository extends JpaRepository<Address,Long>  {
    
}
