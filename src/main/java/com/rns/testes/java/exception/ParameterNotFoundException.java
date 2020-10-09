package com.rns.testes.java.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ParameterNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private List<String> reasons = new ArrayList<>();

    public ParameterNotFoundException(String message) {
	super(message);
    }

    public ParameterNotFoundException(String message, List<String> reasons) {
	super(message);
	this.reasons = reasons;
    }

    public ParameterNotFoundException(String message, String... reasons) {
	super(message);
	this.reasons.addAll(Arrays.asList(reasons));
    }

    public List<String> getReasons() {
	return Collections.unmodifiableList(reasons);
    }
}
