import java.util.ArrayList;

public class ManagingRates {
	ArrayList<Beacehs[]> allthebeaches;
	Beacehs[] beacehs1;
	Beacehs[] beacehs2;
	Beacehs[] beacehs3;

	public ManagingRates() {

		beacehs1 = new Beacehs[4];

		beacehs1[0] = new Beacehs("Hilton");
		beacehs1[1] = new Beacehs("Palmachim");
		beacehs1[2] = new Beacehs("Golshim");
		beacehs1[3] = new Beacehs("Bat galim");

		beacehs2 = new Beacehs[4];

		beacehs1[0] = new Beacehs("Hilton");
		beacehs1[1] = new Beacehs("Palmachim");
		beacehs1[2] = new Beacehs("Golshim");
		beacehs1[3] = new Beacehs("Bat galim");

		beacehs3 = new Beacehs[4];

		beacehs1[0] = new Beacehs("Hilton");
		beacehs1[1] = new Beacehs("Palmachim");
		beacehs1[2] = new Beacehs("Golshim");
		beacehs1[3] = new Beacehs("Bat galim");

		allthebeaches = new ArrayList<>();
		allthebeaches.add(beacehs1);
		allthebeaches.add(beacehs2);
		allthebeaches.add(beacehs3);
	}

	// entering the rates of the waves to the third object in arraylist
	public void enteringvalues(byte[] recieve) {
		if (beacehs1.equals(allthebeaches.get(2))) {

			beacehs1[recieve[1]].a += recieve[2];
			beacehs1[recieve[1]].b += recieve[3];
			beacehs1[recieve[1]].c += recieve[4];
			beacehs1[recieve[1]].d += recieve[5];
			beacehs1[recieve[1]].counter++;
			System.out.println("beaches 1 got the values");
		}

		else if (beacehs2.equals(allthebeaches.get(2))) {

			beacehs2[recieve[1]].a += recieve[2];
			beacehs2[recieve[1]].b += recieve[3];
			beacehs2[recieve[1]].c += recieve[4];
			beacehs2[recieve[1]].d += recieve[5];
			beacehs2[recieve[1]].counter++;
			System.out.println("beaches 2 got the values");
		} else {
			beacehs3[recieve[1]].a += recieve[2];
			beacehs3[recieve[1]].b += recieve[3];
			beacehs3[recieve[1]].c += recieve[4];
			beacehs3[recieve[1]].d += recieve[5];
			beacehs3[recieve[1]].counter++;
			System.out.println("beaches 3 got the values");

		}

	}

	public byte[] readyvaluestosend(byte idnumber) {
		int counterbeach1 = beacehs1[idnumber].counter;
		int counterbeach2 = beacehs2[idnumber].counter;
		int counterbeach3 = beacehs3[idnumber].counter;

		if (counterbeach1 > 0 && counterbeach2 > 0 && counterbeach3 > 0) {
			int counter = counterbeach1 + counterbeach2 + counterbeach3;
			byte[] response = new byte[] {

					(byte) ((beacehs1[idnumber].a + beacehs2[idnumber].a + beacehs3[idnumber].a) / counter),
					(byte) ((beacehs1[idnumber].b + beacehs2[idnumber].b + beacehs3[idnumber].b) / counter),
					(byte) ((beacehs1[idnumber].c + beacehs2[idnumber].c + beacehs3[idnumber].c) / counter),
					(byte) ((beacehs1[idnumber].d + beacehs2[idnumber].b + beacehs3[idnumber].b) / counter),
					(byte) counter };
			System.out.println("the counter counter123 = " + counter);
			return response;

		} else if (counterbeach1 > 0 && counterbeach2 > 0) {
			int counter = counterbeach1 + counterbeach2;
			byte[] response = new byte[] {

					(byte) ((beacehs1[idnumber].a + beacehs2[idnumber].a) / counter),
					(byte) ((beacehs1[idnumber].b + beacehs2[idnumber].b) / counter),
					(byte) ((beacehs1[idnumber].c + beacehs2[idnumber].c) / counter),
					(byte) ((beacehs1[idnumber].d + beacehs2[idnumber].b) / counter),
					(byte) counter };
			System.out.println("the counter counter12= " + counter);
			return response;
		} else if (counterbeach1 > 0 && counterbeach3 > 0) {
			int counter = counterbeach1 + counterbeach3;
			byte[] response = new byte[] {

					(byte) ((beacehs1[idnumber].a + beacehs3[idnumber].a) / counter),
					(byte) ((beacehs1[idnumber].b + beacehs3[idnumber].b) / counter),
					(byte) ((beacehs1[idnumber].c + beacehs3[idnumber].c) / counter),
					(byte) ((beacehs1[idnumber].d + beacehs3[idnumber].b) / counter),
					(byte) counter };
			System.out.println("the counter counter13= " + counter);
			return response;
		} else if (counterbeach2 > 0 && counterbeach3 > 0) {
			int counter = counterbeach2 + counterbeach3;
			byte[] response = new byte[] {

					(byte) ((beacehs2[idnumber].a + beacehs3[idnumber].a) / counter),
					(byte) ((beacehs2[idnumber].b + beacehs3[idnumber].b) / counter),
					(byte) ((beacehs2[idnumber].c + beacehs3[idnumber].c) / counter),
					(byte) ((beacehs2[idnumber].d + beacehs3[idnumber].b) / counter),
					(byte) counter };
			System.out.println("the counter counter23= " + counter);
			return response;
		} else if (counterbeach3 > 0) {
			int counter = counterbeach3;

			byte[] response = new byte[] {

			(byte) ((beacehs3[idnumber].a) / counter),
					(byte) ((beacehs3[idnumber].b) / counter),
					(byte) ((beacehs3[idnumber].c) / counter),
					(byte) ((beacehs3[idnumber].d) / counter), (byte) counter };
			System.out.println("the counter counter3= " + counter);
			return response;

		} else if (counterbeach2 > 0) {
			int counter = counterbeach2;
			System.out.println("the counter counter2= " + counter);
			byte[] response = new byte[] {

			(byte) ((beacehs2[idnumber].a) / counter),
					(byte) ((beacehs2[idnumber].b) / counter),
					(byte) ((beacehs2[idnumber].c) / counter),
					(byte) ((beacehs2[idnumber].d) / counter), (byte) counter };
			return response;
		} else if (counterbeach1 > 0) {
			int counter = counterbeach1;
			System.out.println("the counter counter1= " + counter);
			byte[] response = new byte[] {

			(byte) ((beacehs1[idnumber].a) / counter),
					(byte) ((beacehs1[idnumber].b) / counter),
					(byte) ((beacehs1[idnumber].c) / counter),
					(byte) ((beacehs1[idnumber].d) / counter), (byte) counter };
			System.out.println("the counter counter1= " + counter);
			return response;
		} else {
			System.out.println("no values");
			byte[] response = new byte[] { 0, 0, 0, 0, 0 };
			return response;

		}

	}

	public void restartingValues() {
		if (beacehs1.equals(allthebeaches.get(0))) {
			allthebeaches.remove(0);

			beacehs1 = new Beacehs[4];

			beacehs1[0] = new Beacehs("Hilton");
			beacehs1[1] = new Beacehs("Palmachim");
			beacehs1[2] = new Beacehs("Golshim");
			beacehs1[3] = new Beacehs("Bat galim");
			allthebeaches.add(beacehs1);
			System.out.println("cleared beaches1");
		} else if (beacehs2.equals(allthebeaches.get(0))) {
			allthebeaches.remove(0);
			beacehs2 = new Beacehs[4];

			beacehs2[0] = new Beacehs("Hilton");
			beacehs2[1] = new Beacehs("Palmachim");
			beacehs2[2] = new Beacehs("Golshim");
			beacehs2[3] = new Beacehs("Bat galim");
			allthebeaches.add(beacehs2);
			System.out.println("cleared beaches2");

		} else {
			allthebeaches.remove(0);
			beacehs3 = new Beacehs[4];
			beacehs3[0] = new Beacehs("Hilton");
			beacehs3[1] = new Beacehs("Palmachim");
			beacehs3[2] = new Beacehs("Golshim");
			beacehs3[3] = new Beacehs("Bat galim");
			allthebeaches.add(beacehs3);
			System.out.println("cleared beaches3");

		}
	}

	// not in used
	public byte[] retrivinginfo(byte number) {
		byte[] info = beacehs1[number].info.getBytes();
		return info;

	}

}
