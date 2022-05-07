package serverCode;


import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Server server = new Server(4999);
		server.start();
		server.makePlayers();
		System.out.println()
		Scanner scanner = new Scanner(System.in);
		if (scanner.nextLine().equalsIgnoreCase("quit")) {
			server.close();
			System.out.println("Closing server");
			scanner.close();
		}
		System.out.println("Somehow Here");
		
		
	}

}
