package assig3_2;
//dmitri podoluk 317059244

public class judge extends Thread {
	GamePlay GamePlay;

	judge(GamePlay GamePlay) {

		this.GamePlay = GamePlay;
	}

	public void run() {

		while (!isInterrupted()) {

			try {

				this.GamePlay.makeCoinAvail(false);
				Thread.sleep(1000);

				this.GamePlay.makeCoinAvail(true);

				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				interrupt();
			}

		}
	}

}
