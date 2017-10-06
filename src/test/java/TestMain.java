import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.co.rodderscode.bbc.Fetcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class TestMain {

    Fetcher fetcher;

    @Before
    public void setup()
    {
        this.fetcher = new Fetcher();
    }

    @After
    public void tearDown()
    {

    }


    @Test
    public void testRandomSentence()
    {

        String s = "lsdfjslf 305 REDIRECTED";
        Pattern p = Pattern.compile("([\\d]+)");
        Matcher m = p.matcher(s);
        assertEquals(false, m.matches());
        assertEquals(true, m.find());
        assertEquals("305", m.group(1));
    }

    @Test
    public void testHttpResponseFormat()
    {
        String s = "[HTTP/1.1 200 OK]";
        Pattern p = Pattern.compile("([\\d]{3})");
        Matcher m = p.matcher(s);
        assertEquals(false, m.matches());
        assertEquals(true, m.find());
        assertEquals("200", m.group(1));
    }




}
