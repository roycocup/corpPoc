import com.oracle.javafx.jmx.json.JSONDocument;
import com.oracle.javafx.jmx.json.JSONReader;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.co.rodderscode.bbc.Fetcher;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class TestMain {

    private Fetcher fetcher;

    @Before
    public void setup()
    {
        this.fetcher = new Fetcher();
    }

    @After
    public void tearDown(){}

    public static String ArrayToString(ArrayList<String> al)
    {
        StringBuilder sb = new StringBuilder();
        for (String s : al)
        {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Test
    public void test_stats_is_json_object()
    {
        String stats = this.fetcher.getStats();

        try {
            new JSONObject(stats);
        } catch (JSONException ex) {
            try {
                new JSONArray(stats);
            } catch (JSONException ex1) {
                assert(false);
            }
        }
        assert(true);
    }


}
