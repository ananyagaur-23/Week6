package nu;

import java.io.*;
import java.net.*;

public class SimpleWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started at http://localhost:8080");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            String line;
            while (!(line = in.readLine()).isEmpty()) {
                System.out.println(line);
            }

            String response = "Hello from Java Web Server!";
            out.write("HTTP/1.0 200 OK\r\n");
            out.write("Content-Type: text/plain\r\n");
            out.write("Content-Length: " + response.length() + "\r\n");
            out.write("\r\n");
            out.write(response);
            out.flush();

            clientSocket.close();
        }
    }
}
