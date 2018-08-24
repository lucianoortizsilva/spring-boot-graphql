package com.lucianoortizsilva.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
public class Person implements Serializable {

	private static final long serialVersionUID = 2557740240448374706L;

	enum Genre {
		MALE, FEMALE
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private Integer age;

	private Genre genre;

	@DateTimeFormat(pattern = "yyyy-MM-dd", iso = ISO.DATE, style = "yyyy-MM-dd")
	private LocalDate dtBirth;

}