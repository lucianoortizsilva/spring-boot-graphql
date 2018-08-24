package com.lucianoortizsilva.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucianoortizsilva.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}