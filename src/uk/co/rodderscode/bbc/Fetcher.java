package uk.co.rodderscode.bbc;

import java.net.*;
import java.io.*;


public class Fetcher {

    public static void main(String[] args)
    {
        Fetcher f = new Fetcher();
        System.out.println("hey");
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
