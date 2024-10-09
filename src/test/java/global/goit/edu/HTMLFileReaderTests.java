package global.goit.edu;

import global.goit.edu.filereader.HTMLFileReader;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.StringJoiner;

public class HTMLFileReaderTests {

    @Test
    public void testThatMethodReadWorkOk() throws IOException {

        //Given
        File file = new File("src/test/resources/index.html");
        StringJoiner expected = new StringJoiner("\n");
        expected.add("<body>");
        expected.add("<h3>");
        expected.add("</h3>");
        expected.add("</body>");
        OutputStream out = new FileOutputStream(file);
        out.write(expected.toString().getBytes());

        //When
        String actual = HTMLFileReader.read(file.getPath());

        //Then
        Assert.assertEquals(expected.toString(),actual);

    }
}
