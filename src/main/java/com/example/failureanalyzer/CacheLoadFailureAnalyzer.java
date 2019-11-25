package com.example.failureanalyzer;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class CacheLoadFailureAnalyzer extends AbstractFailureAnalyzer<CacheLoadFailedException> {

  @Override
  protected FailureAnalysis analyze(Throwable rootFailure, CacheLoadFailedException cause) {
    ServiceType serviceType = cause.getServiceType();
    if (serviceType == ServiceType.REDIS) {
      return new FailureAnalysis(
        cause.getMessage(),
        "Please ensure redis is running on port 6379",
        cause
      );
    } else if (serviceType == ServiceType.POSTGRES) {
      return new FailureAnalysis(
        cause.getMessage(),
        "Please ensure postgres is running on port 5432",
        cause
      );
    }
    throw cause;
  }

}
