package Utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.GZIPOutputStream;

public final class CompressionUtils {

  private CompressionUtils() {
    // private constructor to avoid class instantiation as this class holds only utility methods.
  }

  /**
   * GZIP String.
   *
   * @param data String
   * @return ByteBuffer
   */
  public static ByteBuffer zip(String data) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (GZIPOutputStream gzipOut = new GZIPOutputStream(baos)) {
      gzipOut.write(data.getBytes(Charset.defaultCharset()));
    } catch (IOException e) {
      throw new RuntimeException("Cannot uncompress data", e);
    }
    return ByteBuffer.wrap(baos.toByteArray());
  }

  /**
   * GZIP String.
   *
   * @param data String
   * @return Byte Array
   */
  public static byte[] zip(String data, Boolean toBytes) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (GZIPOutputStream gzipOut = new GZIPOutputStream(baos)) {
      gzipOut.write(data.getBytes(Charset.defaultCharset()));
    } catch (IOException e) {
      throw new RuntimeException("Cannot uncompress data", e);
    }
    return (toBytes) ? baos.toByteArray() : null;
  }
}
