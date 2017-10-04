import java.net.*;
import java.io.*;


public class Fetcher {

    public static void main(String[] argv)
    {
        Fetcher f = new Fetcher();
    }


    public void reader() throws Exception
    {
        URL yahoo = new URL("http://www.yahoo.com/");

        URLConnection yc = yahoo.openConnection();
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(yc.getInputStream())
        );

        String inputLine;

        while ((inputLine = bufferedReader.readLine()) != null)
            System.out.println(inputLine);

        bufferedReader.close();
    }



}
