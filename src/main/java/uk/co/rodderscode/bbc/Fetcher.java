package uk.co.rodderscode.bbc;


import org.apache.commons.validator.routines.UrlValidator;
import org.json.JSONWriter;

import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Fetcher f = new Fetcher();
        f.run();
    }
    
    
    public void run()
    {
        // clear the screen
        clear();


        // start scanner loop
        final Scanner input = new Scanner( System.in );
        System.out.println("Enter urls followed by newline and a single dot (.) on an empty line to end.");

        ArrayList<String> lines = new ArrayList<>();
        String line = "";

        //Todo: make this match exclusively to a empty dot
        while(!line.equals(".")){
            line = input.next();
            lines.add(line);
        }



        // validate urls
        final ArrayList<String> validUrls = new ArrayList<>();
        final ArrayList<String> invalidUrls = new ArrayList<>();
        for(String url : lines){
            if(validateUrl(url)){
                validUrls.add(url);
            } else {
                invalidUrls.add(url);
            }
        }


        System.out.println("These are valid");
        for(String validUrl : validUrls)
            System.out.println(validUrl);


        System.out.println();
        System.out.println("These are NOT valid");
        for(String invalidUrl : invalidUrls)
            System.out.println(invalidUrl);


        // todo: fetch urls, store response, response time, content length, date, error if not reachable,
        ArrayList<LinkedList<HashMap>> rawData = new ArrayList<>();
        for(String url : validUrls)
        {
            rawData.add(fetchUrlInfo(url));
        }

        StringBuilder s = new StringBuilder();
        JSONWriter jsonWriter = new JSONWriter(s).object();


        jsonWriter.key("data").value(rawData);

        jsonWriter.endObject();

        System.out.println(s.toString());



        // todo: make calculations
//        HashMap<String, Integer> stats;
//        for(HashMap m : rawData)
//        {
//            if (rawData.get())
//            stats.put("Status_Code", m)
//        }


        // todo: compose maps
        // todo: output json
        // todo: polish
        // todo: how to deploy gradle
    }

    /**
     * The program should make an http GET request to each valid address in its input and record particular properties of the http response in the program output.
     • The properties of interest are status code, content length and date-time of the response. These are normally available in the http response headers.
     • Output is a stream of JSON format documents that provide information about the http response for each address in the input
     * The program should identify and report invalid URLs, e.g. those that don't start with http:// or https://, or contain characters not allowed in a URL.
     • The program should cope gracefully when it makes a request to a slow or non-responsive web server, e.g. it could time out the request after ten seconds.
     • The program should have a good set of unit tests.
     • It must be possible to perform a test run, consisting of all unit tests, without accessing the Internet.
     * @param sUrl
     * @return
     */
    public static LinkedList<HashMap> fetchUrlInfo(String sUrl)
    {
        // todo: timeout after x seconds
        LinkedList<HashMap> data = new LinkedList<>();
        HashMap<String, String> details = new HashMap();
        details.put("Url", sUrl);
        try {
            URLConnection conn = new URL(sUrl).openConnection();
            conn.getInputStream();
            Map<String, List<String>> header = conn.getHeaderFields();
//            System.out.println(header);

            if (header.containsKey("Content-Length"))
                details.put("Content_length", header.get("Content-Length").toString());

            if (header.containsKey(null)){
                List<String> l = header.get(null);
                Pattern p = Pattern.compile("([\\d]{3})");
                Matcher m = p.matcher(l.toString());
                details.put("Status_code", (m.find())? m.group(1) : "");
            }

            details.put("Date", header.get("Date").toString());
            data.add(details);

        } catch (Exception e) {
            //todo: is the url not valid because not valid protocol
            //Matcher urlMatcher = URL_PATTERN.matcher(value);
//            if (!urlMatcher.matches()) {
//                return false;
//            }
            //todo: specify malformed, illegal etc...
            details.put("error", e.getClass().toString());
            data.add(details);
        }

        return data;
    }

    public static boolean validateUrl(String url) {
        String[] schemes = {"http","https"}; // DEFAULT schemes = "http", "https", "ftp"
        UrlValidator urlValidator = new UrlValidator(schemes);

        return urlValidator.isValid(url);
    }





}
