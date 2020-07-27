package Concepts;

public class WebSockets {

  /**
   * 1. What is Long polling ?
   *
   * <p>If the server does not have any information available for the client, instead of sending an
   * empty response, the server holds the request and waits for some information to be available.
   *
   * <p>Once the information becomes available (or after a suitable timeout), a complete response is
   * sent to the client. The client will normally then immediately re-request information from the
   * server, so that the server will almost always have an available waiting request that it can use
   * to deliver data in response to an event.
   *
   * <p>In a web/AJAX context, long polling is also known as Comet programming.
   *
   * <p>======================
   *
   * <p>2. What about Websockets ?
   *
   * <p>WebSockets provide a persistent connection between a client and server that both parties can
   * use to start sending data at any time.
   *
   * <p>The client establishes a WebSocket connection through a process known as the WebSocket
   * handshake. This process starts with the client sending a regular HTTP request to the server.
   *
   * <p>An Upgrade header is included in this request that informs the server that the client wishes
   * to establish a WebSocket connection
   *
   * <p>=============================
   *
   * <p>Challenges in Long Polling:
   *
   * <p>It will create a new connection each time, so it will send the HTTP headers... including the
   * cookie header that may be large.
   *
   * <p>It will create a new connection each time, so it will send the HTTP headers... including the
   * cookie header that may be large.
   *
   * <p>If you are using HTTPS, you are doing again and again the most expensive operation, the TLS
   * handshake.
   *
   * <p>Also, when connections are done, log entries are written somewhere, counters are incremented
   * somewhere, memory is consumed, objects are created... etc... etc.
   *
   *
   *
   */
}
