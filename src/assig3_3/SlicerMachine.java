package assig3_3;

import java.util.concurrent.Semaphore;

public class SlicerMachine {

	int numOfCucumbers = 0;
	int numOfTomatoes = 0;
	int numOfPreparedSalads = 0;

	final int cucumbersNeededForOneSalad = 3;
	final int tomatoesNeededForOneSalad = 2;
	int numberOfSaladsPrepare;

	Semaphore tomato = new Semaphore(0);
	Semaphore cucumber = new Semaphore(0);
	Semaphore slicer = new Semaphore(0);

	Object o = new Object();

	public SlicerMachine(int numberOfSaladsPrepare) {
		this.numberOfSaladsPrepare = numberOfSaladsPrepare;

	}

	void addOneCucumber() throws InterruptedException {

		while (numOfCucumbers >= cucumbersNeededForOneSalad) {
			cucumber.acquire();// wait

		}

		if (numOfCucumbers < cucumbersNeededForOneSalad) {
			System.out.println("adding one cucumber to the machine");
			numOfCucumbers++;

			synchronized (o) {
				if (slicer.availablePermits() == 0) {
					slicer.release();
				}
			}
		}

	}

	void addOneTomato() throws InterruptedException {

		while (numOfTomatoes >= tomatoesNeededForOneSalad) {
			tomato.acquire();// wait
		}

		if (numOfTomatoes < tomatoesNeededForOneSalad) {
			numOfTomatoes++;
			System.out.println("adding one tomato to the machine");

			synchronized (o) {
				if (slicer.availablePermits() == 0) {// ensure that only one thread wake up slicer thread
					slicer.release();
				}
			}
		}

	}

	void sliceVegetables() throws InterruptedException {

		while (numOfCucumbers < cucumbersNeededForOneSalad && numOfTomatoes < tomatoesNeededForOneSalad) {
			slicer.acquire();// wait

		}
		if ((numOfCucumbers >= cucumbersNeededForOneSalad) && (numOfTomatoes >= tomatoesNeededForOneSalad)) {

			makeNewSalad();
		}
		cucumber.release();
		tomato.release();

	}

	private void makeNewSalad() throws InterruptedException {
		Thread.sleep(200);
		System.out.println("== preparing one more salad ==");
		numOfPreparedSalads++;
		numOfTomatoes = numOfTomatoes - tomatoesNeededForOneSalad;
		numOfCucumbers = numOfCucumbers - cucumbersNeededForOneSalad;

	}

	int getNumOfPreparedSalads() {
		return numOfPreparedSalads;
	}

	int getNumOfSaladsToPrepare() {
		return numberOfSaladsPrepare;
	}
}
