package uk.co.rodderscode.bbc;

import java.net.*;
import java.io.*;
import java.util.Scanner;


public class Fetcher {

    public static void main(String[] args)
    {
        Fetcher f = new Fetcher();
        f.scan();
    }


    public void print(Object s)
    {
        System.out.println(s);
    }

    public void scan()
    {
        Scanner sc = null;
        try{
            sc = new Scanner(System.in).useDelimiter("\\n");
        } catch (Exception e){
            System.out.println(e);
        }

        print("Starting loop");


        while(sc.equals("\\n")) {
            print("Looping...");
            if (sc.hasNext()){
                s = sc.next();
                print(s);
            }

        }

        print("End loop");
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
