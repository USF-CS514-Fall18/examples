package sockets;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 * Shows how to write a WebClient that can send a GET request to a website that
 * uses https. In this example, we fetch a specific movie page from themoviedb.org.
 *
 * Note that links.csv posted on Canvas maps each movieId from the grouplens data to
 * the movie id in themoviedb.org.
 * Modified from the example at:
 * http://www.jguru.com/faq/view.jsp?EID=32388
 */
public class WebClientSSL {


    public static String getMovieInfo() {
        String s = "";

        String urlString = "https://www.themoviedb.org/movie/8844-jumanji" ; //https://www.themoviedb.org/movie/862-toy-story";
        URL url;
        PrintWriter out = null;
        BufferedReader in = null;
        SSLSocket socket = null;
        try {
            url = new URL(urlString);

            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

            // HTTPS uses port 443
            socket = (SSLSocket) factory.createSocket(url.getHost(), 443);

            // output stream for the secure socket
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            String request = getRequest(url.getHost(), url.getPath() + "?" + url.getQuery());
            System.out.println("Request: " + request);

            out.println(request); // send a request to the server
            out.flush();

            // input stream for the secure socket.
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // use input stream to read server's response
            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = in.readLine()) != null) {
                //System.out.println(line);
                if (line.contains("content=\"https://image.tmdb.org")) {
                    sb.append(line); // want only the image of the movie
                    break;
                }
            }
            s = sb.toString();
        } catch (IOException e) {
            System.out.println(
                    "An IOException occured while writing to the socket stream or reading from the stream: " + e);
        } finally {
            try {
                // close the streams and the socket
                out.close();
                in.close();
                socket.close();
            } catch (IOException e) {
                System.out.println("An exception occured while trying to close the streams or the socket: " + e);
            }
        }

        return s;

    }

    /**
     * Takes a host and a string containing path/resource/query and creates a
     * string of the HTTP GET request
     *
     * @param host
     * @param pathResourceQuery
     * @return
     */
    private static String getRequest(String host, String pathResourceQuery) {
        String request = "GET " + pathResourceQuery + " HTTP/1.1" + System.lineSeparator() // GET
                // request
                + "Host: " + host + System.lineSeparator() // Host header required for HTTP/1.1
                + "Connection: close" + System.lineSeparator() // make sure the server closes the
                // connection after we fetch one page
                + System.lineSeparator();
        return request;
    }


    /**
     * Extracts the image link from the html page
     * @param str
     * @return
     */
    public static String extractImageLink(String str) {
        // extract the image: first find the quote right before https
        // Note: would be better to use regex
        String imageLink = "";
        int count = 0;
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '"') {
                count++;
                if (count == 3) {
                    j = i + 1;
                    break;
                }
            }
        }
        for (int i = j; i < str.length(); i++) {
            if (str.charAt(i) == '"')
                break;
            imageLink += str.charAt(i);
        }
        return imageLink;
    }

    /**
     * The main method for the WebClientSSL example
     * @param args
     */
    public static void main(String[] args) {
        String result = getMovieInfo();
        String imageLink = extractImageLink(result);
        System.out.println(imageLink);
    }
}
