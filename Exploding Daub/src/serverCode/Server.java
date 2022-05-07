package serverCode;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import gameCode.*;


public class Server {
	//Socket Stuff
	private int port;
	private ServerSocket sSocket;
	
	//Game Stuff
	private ArrayList<ClientHandler> clients;
	private ExecutorService pool;
	private Game game;
	
	public Server(int portNum) throws IOException {
		port = portNum;
		clients = new ArrayList<ClientHandler>();
		sSocket = new ServerSocket(port);
		pool = Executors.newFixedThreadPool(4);
	}
	
	public void start() throws IOException {
		while(clients.size() < 1) {
			System.out.println(clients.size());
			ClientHandler client = new ClientHandler(sSocket.accept());
			clients.add(client);
		}
	}
	
	public void close() throws IOException {
		sSocket.close();
		pool.shutdown();
	}
	
	public void makePlayers() {
		ArrayList<Player> players = new ArrayList<Player>();
		for (ClientHandler client:clients) {
			try {
				players.add(new Player(client.askForName(), client));
			}catch (IOException e) {
				clients.remove(clients.indexOf(client));
			}
		}
	}
}
