package com.example.demo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
 private Socket socket = null ;
 public ClientThread (Socket socket) { this.socket = socket ; }
 public void run () {
 try {
 BufferedReader in = new BufferedReader(
 new InputStreamReader(socket.getInputStream()));
 String request="a";
 String raspuns="a";
 int ok=1;
 PrintWriter out = new PrintWriter(socket.getOutputStream());
 while(ok==1) {
 request = in.readLine();
 if(request.equals("stop")) {
	 raspuns = "Server stopped";
	 ok=0;
 }
 else
 {
 raspuns = "Server received the request : " + request;
 }
 out.println(raspuns);
 out.flush();
 }
 } catch (IOException e) {
 System.err.println("Communication error... " + e);
 } finally {
 try {
 socket.close();
 } catch (IOException e) { System.err.println (e); }
 }
 }
}