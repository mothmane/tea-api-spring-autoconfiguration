package com.othmane;

import com.othmane.services.exceptions.InvalidTeaCombinationException;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class InvalidTeaCombinationFailureAnalyzer  extends AbstractFailureAnalyzer<InvalidTeaCombinationException> {

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, InvalidTeaCombinationException cause) {
        return  new FailureAnalysis("Monsieur on ne sert jamais de Thé noir froid","veuillez choisir un autre thé",cause);
    }
}
