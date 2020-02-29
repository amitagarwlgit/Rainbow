package com.learning.rainbow.foyer.service;

import com.learning.rainbow.foyer.model.StreamResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

@SpringBootTest
class StreamServiceTest {

  @Autowired private StreamService streamService;

  private static final String eventIdRegex =
      "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}";

  @Test
  void testIngestStreamPositive() {
    String payload = "test data";
    InputStream inputStream = new ByteArrayInputStream(payload.getBytes(Charset.forName("UTF-8")));
    StreamResponse response = streamService.ingest("OMS", inputStream);
    Assertions.assertEquals(
        Pattern.compile(eventIdRegex).matcher(response.getEventId()).matches(), true);
  }
}
