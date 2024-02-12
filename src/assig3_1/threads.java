package assig3_1;
//dmitri podoluk 317059244
public class threads {

	static boolean aRun = true;
	static boolean bRun = false;
	static boolean cRun = false;
	static Object o = new Object();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Thread() {
			public void run() {
				while (true) {

					synchronized (o) {

						if (aRun) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("A");
							aRun = false;
							bRun = true;

						}
					}
				}
			}
		}.start();

		new Thread() {
			public void run() {
				while (true) {
					synchronized (o) {

						if (bRun) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("B");
							cRun = true;

						}

					}

				}
			}

		}.start();

		new Thread() {
			public void run() {
				while (true) {
					synchronized (o) {
						if (cRun) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("C");
							aRun = true;
							bRun = false;
							cRun = false;

						}
					}

				}
			}

		}.start();

	}
}