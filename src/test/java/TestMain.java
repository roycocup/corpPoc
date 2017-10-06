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
    public void testRegex()
    {

        String s = "lsdfjslf 305 REDIRECTED";
        Pattern p = Pattern.compile("([\\d]+)");
        Matcher m = p.matcher(s);

        System.out.println("Matches? " + m.matches());
        System.out.println("Groupcount: " + m.groupCount());
        System.out.println("Find? " + m.find());
        if(m.find()){
            System.out.println("Group: " + m.group(1));
        }
        else
            System.out.println("No Match");

        assertEquals("305", m.group(1));
    }




}
