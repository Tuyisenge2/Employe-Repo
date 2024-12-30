package com.mypackage.demoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypackage.demoApp.model.Employee;

public interface repository extends JpaRepository<Employee,Long> { }
