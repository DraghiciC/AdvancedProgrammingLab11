package com.example.demo;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
 public static final int PORT = 8100;
 public GameServer() throws IOException {
 ServerSocket serverSocket = null ;
 try {
 serverSocket = new ServerSocket();
 serverSocket.setReuseAddress(true); 
 serverSocket.bind(new InetSocketAddress(PORT));
 while (true) {
 System.out.println ("Waiting for a client ...");
 Socket socket = serverSocket.accept();
 new ClientThread(socket).start();
 }
 } catch (IOException e) {
 System.err. println ("Ooops... " + e);
 } finally {
 serverSocket.close();
 }
 }
 public static void main ( String [] args ) throws IOException {
 GameServer server = new GameServer ();
 }
}