package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Register;

public interface RegisterRepository extends JpaRepository<Register, Long> {

}
