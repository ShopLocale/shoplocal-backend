package com.shoplocal.configuration.cache;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Date: 12/31/2020
 *
 * @author Kushal Roy
 */
@Service
public class CacheEventLogger implements CacheEventListener<Object, Object> {

  private static final Logger log = LoggerFactory.getLogger(CacheEventLogger.class);

  @Override
  public void onEvent(CacheEvent<? extends Object, ? extends Object> cacheEvent) {
    log.info(
        "Cache event = {}, Key = {},  Old value = {}, New value = {}",
        cacheEvent.getType(),
        cacheEvent.getKey(),
        cacheEvent.getOldValue(),
        cacheEvent.getNewValue());
  }
}
