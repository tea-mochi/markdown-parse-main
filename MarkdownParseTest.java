import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

//javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
//java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testCase1() throws IOException{
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(Files.readString(Path.of("test-file.md"))));
    }

    @Test
    public void testCase2() throws IOException{
        assertEquals(List.of(), MarkdownParse.getLinks(Files.readString(Path.of("noLinkFile.md"))));
    }
    @Test
    public void testCase3() throws IOException{
        assertEquals(List.of(), MarkdownParse.getLinks(Files.readString(Path.of("fakeLink.md"))));
    }
    @Test
    public void testCase4() throws IOException{
        assertEquals(List.of(), MarkdownParse.getLinks(Files.readString(Path.of("imageTest.md"))));
    }
}