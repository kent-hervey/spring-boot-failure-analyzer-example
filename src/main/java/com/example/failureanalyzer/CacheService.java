package com.example.failureanalyzer;

import org.springframework.stereotype.Component;

@Component
public class CacheService {

  public void load() {
    throw new CacheLoadFailedException(ServiceType.REDIS, "Application failed to start");
  }
}
