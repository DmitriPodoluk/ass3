package assig3_3;

public class SlicerThread extends Thread {
	SlicerMachine SlicerMachine;

	SlicerThread(SlicerMachine SlicerMachine) {
		this.SlicerMachine = SlicerMachine;
	}

	public void run() {
		while (this.SlicerMachine.getNumOfPreparedSalads() < this.SlicerMachine.getNumOfSaladsToPrepare()) {

			try {
				this.SlicerMachine.sliceVegetables();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
