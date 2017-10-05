package uk.co.rodderscode.bbc;


import java.util.Scanner;

public class Fetcher {

    public static void main(String[] args)
    {

        // start scanner loop
        Scanner input = new Scanner( System.in );
        System.out.println("Enter urls followed by newline. A single newline will mark EOF");

        String text;

        text = input.next();

        System.out.println("you said: " + text);

        // split into list
        // fetch urls
        // capture data
        // make calculations
        // compose maps
        // output json

    }


}
