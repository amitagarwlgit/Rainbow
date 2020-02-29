package com.learning.rainbow.foyer.service;

import com.learning.rainbow.foyer.model.StreamResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

@Service
public class StreamService {
  private static final Logger LOGGER = LogManager.getLogger();

  public StreamService() {}

  public StreamResponse ingest(String streamName, InputStream inputStream) {
    LOGGER.info("Got the message for stream {}", streamName);
    return new StreamResponse(UUID.randomUUID().toString());
  }
}




