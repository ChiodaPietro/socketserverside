package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Main {
    public static void main(String[] args)  {
        try {
            ServerSocket server = new ServerSocket(6666);
            Socket client = server.accept(); // blocking method, waits until the client connects
            System.out.println("client connected");
            PrintWriter writer = new PrintWriter(client.getOutputStream(),true);
            //true, flush, means that the writer sends a line hop to say, "hey i am done writing"; and it flushes everyting it got
            BufferedReader serverreader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            int first;
            System.out.println("waiting the two numbers");
            first   =Integer.parseInt(serverreader.readLine());
            int second;
            second=Integer.parseInt(serverreader.readLine());
            System.out.println("message received: "+first+" "+second);
            writer.println(first+second);
            client.close();
        }catch (IOException e){
            System.out.println("exception during the connection");
        }
    }
}