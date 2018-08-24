package com.lucianoortizsilva.endpoint;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lucianoortizsilva.service.PersonService;

import graphql.ExecutionInput;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.query.PublicResolverBuilder;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;

@RestController
public class GraphQLController {

	private final GraphQL graphQL;
	private final String SCHEMA = "com..lucianoortizsilva.model";

	// @formatter:off
	@Autowired
	public GraphQLController(final PersonService PersonService) {
		final GraphQLSchema schema = new GraphQLSchemaGenerator()
				.withResolverBuilders(new AnnotatedResolverBuilder(), 
						              new PublicResolverBuilder(SCHEMA))
				.withOperationsFromSingleton(PersonService)
				.withValueMapperFactory(new JacksonValueMapperFactory())
				.generate();
		this.graphQL = GraphQL.newGraphQL(schema).build();
	}





	// @formatter:off
	@PostMapping("/graphql")
	@ResponseBody
	public Map<String, Object> post(@RequestBody final Map<String, String> input, final HttpServletRequest raw) {
		return this.graphQL.execute(ExecutionInput.newExecutionInput()
						   .query(input.get("query"))
                           .operationName(input.get("operationName"))
                           .context(raw)
                           .build()).toSpecification();
	}

}