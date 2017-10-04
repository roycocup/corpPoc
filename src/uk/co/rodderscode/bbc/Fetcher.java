package uk.co.rodderscode.bbc;

import java.net.*;
import java.io.*;


public class Fetcher {

    public static void main(String[] args) {
        Fetcher f = new Fetcher();


        String d = f.getTestData();

        try {
            f.fetch(new URL("http://yahoo.com"));
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public String getTestData()
    {
        return "http://www.bbc.co.uk/iplayer\n" +
                "https://google.com\n" +
                "bad://address\n" +
                "http://www.bbc.co.uk/missing/thing\n" +
                "http://not.exists.bbc.co.uk/\n" +
                "http://www.oracle.com/technetwork/java/javase/downloads/index.html https://www.pets4homes.co.uk/images" +
                        "/articles/1646/large/kitten-emergencies-signs-to-look-out-for- 537479947ec1c.jpg\n" +
                "http://site.mockito.org/" +
                "\n\n";
    }


    public void fetch(URL url) {

        BufferedReader bufferedReader;

        try{
            URLConnection yc = url.openConnection();
            bufferedReader = new BufferedReader(
                    new InputStreamReader(yc.getInputStream())
            );
            String inputLine;

            while ((inputLine = bufferedReader.readLine()) != null)
                System.out.println(inputLine);

            bufferedReader.close();
        } catch (IOException e){
            System.out.println("Problems opening connection");
        }



    }



}
