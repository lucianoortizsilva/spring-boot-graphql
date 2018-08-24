package com.lucianoortizsilva.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucianoortizsilva.model.Person;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	@GraphQLQuery(name = "findAllPerson")
	public List<Person> findAll() {
		return repository.findAll();
	}

	@GraphQLMutation(name = "createPerson")
	public Person create(@GraphQLArgument(name = "person") final Person person) {
		return this.repository.save(person);
	}

	@GraphQLMutation(name = "updatePerson")
	public Person update(@GraphQLArgument(name = "person") final Person person) {
		final Person p = this.repository.getOne(person.getId());
		if (p == null) {
			return null;
		} else {
			p.setAge(person.getAge());
			p.setName(person.getName());
			p.setGenre(person.getGenre());
			p.setDtBirth(person.getDtBirth());
			return this.repository.save(person);
		}
	}

	@GraphQLMutation(name = "deletePerson")
	public void delete(@GraphQLArgument(name = "id") final Long id) {
		final Person p = this.repository.getOne(id);
		if (p != null) {
			this.repository.delete(id);
		}
	}

}