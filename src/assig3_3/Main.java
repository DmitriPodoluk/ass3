package assig3_3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Please Type How Many Salads To Prepare:");
		Scanner scan = new Scanner(System.in);
		final int numOfSaladsToPrepare = scan.nextInt();
		System.out.println("Preparing " + numOfSaladsToPrepare + " Salads...");

		SlicerMachine SlicerMachine = new SlicerMachine(numOfSaladsToPrepare);
		SlicerThread SlicerThread = new SlicerThread(SlicerMachine);
		CucumbersThread CucumbersThread = new CucumbersThread(SlicerMachine);
		TomatoesThread TomatoesThread = new TomatoesThread(SlicerMachine);

		SlicerThread.start();
		CucumbersThread.start();
		TomatoesThread.start();

		try {

			SlicerThread.join();
			CucumbersThread.join();
			TomatoesThread.join();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Done");
		scan.close();
	}

}
