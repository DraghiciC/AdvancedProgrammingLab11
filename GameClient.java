package com.example.demo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.net.SocketException;
public class GameClient {
 public static void main (String[] args) throws IOException {
 String serverAddress = "127.0.0.1"; // The server's IP address
 int PORT = 8100; // The server's port
 try (
 Socket socket = new Socket(serverAddress, PORT);
 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
 BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()))) {
	 Scanner scanner = new Scanner(System. in);
	 String request = null;
	 int ok=1;
while(ok==1) {
try {
 request = scanner. nextLine();
 if(request.equals("exit")) {
	 ok=0;
 }
 else {
 out.println(request);
 String response = in.readLine ();
 System.out.println(response);
 }
 }
 catch (SocketException e) {
	 System.err.println("The server was stopped");
	 }
 }
 } catch (UnknownHostException e) {
 System.err.println("No server listening... " + e);
 }
 }
}