package assig3_2;
//dmitri podoluk 317059244

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GamePlay game = new GamePlay();
		Gamer gamer1 = new Gamer(game);
		Gamer gamer2 = new Gamer(game);
		judge judge = new judge(game);

		gamer1.start();
		gamer2.start();
		judge.start();

		try {

			gamer1.join();
			gamer2.join();

		} catch (Exception e) {
			// System.out.println("Exception handled");
		}

		judge.interrupt();
		int score1 = gamer1.getScore();
		int score2 = gamer2.getScore();
		if (score1 > score2) {
			System.out.println(gamer1.getName() + " is wineer");

		} else {
			if (score1 < score2) {
				System.out.println(gamer2.getName() + " is wineer");
			}
			if (score1 == score2) {
				System.out.println("tie!");
			}

		}
	}

}
