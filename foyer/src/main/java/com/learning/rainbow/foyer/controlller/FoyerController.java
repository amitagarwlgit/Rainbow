package com.learning.rainbow.foyer.controlller;

import com.learning.rainbow.foyer.model.StreamResponse;
import com.learning.rainbow.foyer.service.StreamService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.io.InputStream;
import java.util.UUID;

@RestController
public class FoyerController {

  private static final Logger LOGGER = LogManager.getLogger();

  @Autowired StreamService streamService;

  public FoyerController() {}

  @PostMapping(path = "/{stream}/submit")
  public StreamResponse handleStream(
          final InputStream inputStream, @PathVariable String stream, @RequestHeader HttpHeaders httpHeaders) {
    return streamService.ingest(stream, inputStream);
  }
}
