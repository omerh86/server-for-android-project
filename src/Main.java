import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
	static ManagingRates managingRates;
	static Data data;
	public static void main(String[] args) {
		managingRates = new ManagingRates();
		data =new Data();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1000*120);
						managingRates.restartingValues();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
		}).start();
		try {
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(12000);
			while (true) {
				System.out.println("waiting for incoming communication.");
				Socket client = serverSocket.accept();
				ClientThread clientThread = new ClientThread(client);
				clientThread.start();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
}


