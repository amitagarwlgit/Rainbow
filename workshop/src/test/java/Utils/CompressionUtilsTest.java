package Utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CompressionUtilsTest {

  @Test
  void zipUnzipUsingFile() throws IOException {
    String name = "Amit Agarwal";
    ByteBuffer zippedName = CompressionUtils.zip(name);
    writeToFile(zippedName.array());
    byte[] zippedNameByteArrayBack = readFile();
    String nameBack = unzipFromByteArray(zippedNameByteArrayBack);
    Assertions.assertEquals(name, nameBack);
  }

  @Test
  void zipUnzipUsingBase64() throws IOException {
    String name = "Amit Agarwal";
    ByteBuffer zippedName = CompressionUtils.zip(name);
    String encodedZippedNameString = Base64.encodeBase64String(zippedName.array());
    byte[] zippedNameByteArrayBack = Base64.decodeBase64(encodedZippedNameString);
    String nameBack = unzipFromByteArray(zippedNameByteArrayBack);
    Assertions.assertEquals(name, nameBack);
  }

  private void writeToFile(byte[] byteArr) throws IOException {
    File file = new File("outputfile.txt");
    FileOutputStream fos = new FileOutputStream(file);
    fos.write(byteArr);
  }

  private byte[] readFile() throws IOException {
    File file = new File("outputfile.txt");
    ByteArrayInputStream input = new ByteArrayInputStream(FileUtils.readFileToByteArray(file));
    return IOUtils.toByteArray(input);
  }

  private String unzipFromByteArray(byte[] buffer) throws IOException {
    GZIPInputStream inputStream = new GZIPInputStream(new ByteArrayInputStream(buffer));
    return IOUtils.toString(inputStream, Charset.defaultCharset());
  }
}
