package com.lucianoortizsilva.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.http.HttpStatus;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

/**
 * 
 * @see https://github.com/graphql-java/graphql-java/blob/master/docs/execution.rst
 * @see https://www.howtographql.com/graphql-java/7-error-handling/
 *
 */
public class GraphQLException extends RuntimeException implements GraphQLError {

	private static final long serialVersionUID = -173100092478915559L;

	private final String message;
	private final String key;
	private final int status;

	/**
	 *
	 * @param key informar a key declarada no message.properties
	 * @param message informar alguma mensagem para o desenvolvedor
	 *
	 */
	public GraphQLException(final String key, final String message) {
		Objects.requireNonNull(key, "Informe alguma key, conforme cadastrada no message.properties");
		Objects.requireNonNull(message, "Informe alguma mensagem a nível de Log");
		this.status = HttpStatus.CONFLICT.value();
		this.message = message;
		this.key = key;
	}

	@Override
	public Map<String, Object> getExtensions() {
		final Map<String, Object> customAttributes = new LinkedHashMap<>();
		customAttributes.put("message", this.message);
		customAttributes.put("status", this.status);
		customAttributes.put("key", this.key);
		return customAttributes;
	}

	@Override
	public ErrorType getErrorType() {
		return ErrorType.ValidationError;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public List<SourceLocation> getLocations() {
		return null;
	}

}