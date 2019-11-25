package com.example.failureanalyzer;

public class CacheLoadFailedException extends RuntimeException {

  private ServiceType serviceType;

  public CacheLoadFailedException(ServiceType serviceType, String message) {
    super(message);
    this.serviceType = serviceType;
  }

  public ServiceType getServiceType() {
    return serviceType;
  }
}
