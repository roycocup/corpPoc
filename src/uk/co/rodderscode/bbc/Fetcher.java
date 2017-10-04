package uk.co.rodderscode.bbc;

import java.net.*;
import java.io.*;
import java.util.Scanner;


public class Fetcher {

    public static void main(String[] args)
    {
        Fetcher f = new Fetcher();
        System.out.println("hey");
    }


    public void scan() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            long aLong = sc.nextLong();
        }
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
