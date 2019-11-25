package com.example.failureanalyzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

  @Autowired
  private CacheService cacheService;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    cacheService.load();
  }
}
