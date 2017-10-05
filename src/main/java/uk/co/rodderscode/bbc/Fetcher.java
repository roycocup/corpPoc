package uk.co.rodderscode.bbc;

import java.util.ArrayList;
import java.util.Scanner;

public class Fetcher {

    public static void clear()
    {
        final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
    }

    public static void main(String[] args)
    {

        // clear the screen
        clear();


        // start scanner loop
        Scanner input = new Scanner( System.in );
        System.out.println("Enter urls followed by newline. A single newline will mark EOF");

        ArrayList<String> lines = new ArrayList<>();
        String line = "";

        while(!line.equals(".")){
            line = input.next();
            lines.add(line);
        }

        clear();


        
        // todo:
        // start tests
        // split into list
        // validate urls
        // fetch urls
        // capture data
        // make calculations
        // compose maps
        // output json
        // how to deploy gradle

    }


    public int sum(int a, int b)
    {
        return a+b;
    }





}
