package assig3_3;

public class TomatoesThread extends Thread {
	SlicerMachine SlicerMachine;

	TomatoesThread(SlicerMachine SlicerMachine) {
		this.SlicerMachine = SlicerMachine;
	}

	public void run() {
		while (this.SlicerMachine.getNumOfPreparedSalads() < this.SlicerMachine.getNumOfSaladsToPrepare()) {
		
			try {
				this.SlicerMachine.addOneTomato();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
