package com.ZK.Demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketDemo {
	public static void main(String[] args) throws IOException {
		Socket s = new Socket("127.0.0.1", 8888);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
		pw.println("GET / HTTP/1.1");
		pw.println("Host: localhost");
		pw.println("Content-Type: text/html");
		pw.println();
		pw.flush();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str = "";
		while((str=br.readLine()) != null) {
			System.out.println(str);
		}
		br.close();
		pw.close();
		s.close();
	}

}
