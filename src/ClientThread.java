import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientThread extends Thread {
	Socket client;

	public ClientThread(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		byte[] recieve;
		byte[] send = null;

		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = client.getInputStream();
			outputStream = client.getOutputStream();
			 recieve = new byte[1024];
			System.out.println("working0");
			int actuallyRead;

			if ((actuallyRead = inputStream.read(recieve)) != -1) {
				System.out.println("working1");
				if (recieve[0] == -1) {
					Main.managingRates.enteringvalues(recieve);
					send=Main.managingRates.readyvaluestosend(recieve[1]);
				}
				if(recieve[0]==0){
					String s= Data.spotsxml;
					ObjectOutputStream oos = new ObjectOutputStream(outputStream);
					oos.writeObject(s);
					
					if (oos != null)
						oos.close();
					outputStream.close();
					inputStream.close();
					return;
				}
				if (recieve[0]==1){
					//send=Main.managingRates.retrivinginfo(recieve[1]);
					send=Main.managingRates.readyvaluestosend(recieve[1]);
				}
			}

			System.out.println("working2");
//			
//			byte[] toadd = Main.managingRates.retrivinginfo(recieve[1]);
//			byte[] response = Main.managingRates.readyvaluestosend(recieve[1]);
//			byte[] c = new byte[toadd.length + response.length];
//			int i;
//			for (i = 0; i < response.length; i++)
//				c[i] = response[i];
//
//			for (int j = 0; j < toadd.length; j++)
//				c[i++] = toadd[j];

			outputStream.write(send);

			System.out.println("working3");
			outputStream.close();

			inputStream.close();
			System.out.println("working4");

		} catch (Exception ex) {
			System.out.println("error: " + ex);
		}
	}
}
