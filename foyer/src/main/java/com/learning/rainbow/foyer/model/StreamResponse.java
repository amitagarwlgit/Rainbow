package com.learning.rainbow.foyer.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class StreamResponse {

  @Getter @Setter private String eventId;

  public StreamResponse(String eventId) {
      this.eventId  = eventId;
  }
}
