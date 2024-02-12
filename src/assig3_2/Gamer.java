package assig3_2;
//dmitri podoluk 317059244

public class Gamer extends Thread {
	int goodFlipsCounter;
	GamePlay GamePlay;
	Object o = new Object();

	Gamer(GamePlay GamePlay) {
		this.goodFlipsCounter = 0;
		this.GamePlay = GamePlay;
	}

	public void play() throws InterruptedException {

		while (!Thread.currentThread().isInterrupted() && this.GamePlay.rounds_counter<= 10) {
			if (this.GamePlay.flipCoin()) {
				this.goodFlipsCounter++;
			}

			try {
				sleep(1000);
			} catch (InterruptedException e) {
				break;
			}

		}

	}
	

	public int getScore() {
		return this.goodFlipsCounter;
	}

	public void run() {

		try {
			play();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

}
