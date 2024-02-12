package assig3_2;
//dmitri podoluk 317059244

import java.util.Random;

public class GamePlay {
	boolean _available_coin = true;
	int rounds_counter;
	Random r = new Random();
	Object o = new Object();

	public synchronized void makeCoinAvail(boolean val) {
		this._available_coin = val;
		if (this._available_coin) {
			notifyAll();
		}

	}

	public synchronized boolean flipCoin() throws InterruptedException {
		boolean result;
		while (!this._available_coin) {
			
			System.out.println(Thread.currentThread().getName() + "wait ");
			System.out.println();
			wait();
		}
		makeCoinAvail(false);
		System.out.println(Thread.currentThread().getName() + "flip coin");
		System.out.println();
		this.rounds_counter++;
		result = r.nextBoolean();
		System.out.println(Thread.currentThread().getName() + "get " + result);
		System.out.println();
		makeCoinAvail(true);

		return result;
	}

	public int getNumOfRounds() {
		return this.rounds_counter;
	}
}
