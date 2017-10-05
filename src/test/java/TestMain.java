import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.co.rodderscode.bbc.Fetcher;

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
    public void testTester()
    {
        int expected = 5;
        assertEquals(expected, this.fetcher.sum(1, 4));
        assertEquals(expected, this.fetcher.sum(2, 3));
    }


}
