package serverCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientHandler implements Runnable {
	
	@SuppressWarnings("unused")
	private Socket client;
	private BufferedReader reader;
	private PrintWriter writer;
	@SuppressWarnings("unused")
	private String name;
	public ClientHandler(Socket client) throws IOException {
		this.client = client;
		reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		writer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true);
	}
	
	@Override
	public void run() {
		
		
	}
	public String askForName() throws IOException {
		writer.write("What is your name?");
		return reader.readLine();
	}

}
