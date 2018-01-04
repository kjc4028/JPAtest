package com.example.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.mvc.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Page<Person> findByNameLike(String name, Pageable pageable);
    
    List<Person> countById(Integer age);
}
