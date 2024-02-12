package assig3_3;

public class CucumbersThread extends Thread {
	SlicerMachine SlicerMachine;

	CucumbersThread(SlicerMachine SlicerMachine) {
		this.SlicerMachine = SlicerMachine;
	}

	public void run() {
		while (this.SlicerMachine.getNumOfPreparedSalads() < this.SlicerMachine.getNumOfSaladsToPrepare()) {
			try {
				this.SlicerMachine.addOneCucumber();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
