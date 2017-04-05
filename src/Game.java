import java.util.*;

public class Game {
	static int quaPokers = 3;// 每个玩家拿到的牌张数
	static int quaPlayers = 4;// 玩家数
	static int re = quaPokers * quaPlayers;// 一局里要发的牌数
	int[] record = new int[re];// 用来记录发出的是哪些牌
	int[] playerPoker = new int[quaPokers];// 用来记录一个玩家得到的牌

	int totalCount;// 用来记录一局里已经发出的牌
	Player[] ps = new Player[quaPlayers];

	Game() {
		for (int j = 0; j < quaPokers; j++) {
			playerPoker[j] = 0;
		}
		// 每个对象被赋的是同一个palyPoker,所以ownPoker指向相同，
		for (int i = 0; i < quaPlayers; i++) {
			switch (i) {
			case 0:
				ps[i] = new Player("01", playerPoker);
				break;
			case 1:
				ps[i] = new Player("02", playerPoker);
				break;
			case 2:
				ps[i] = new Player("03", playerPoker);
				break;
			case 3:
				ps[i] = new Player("04", playerPoker);
				break;
			default:
				break;
			}
			ps[i].s = 0;
		}
	}

	void arangePokers(Player a) {// 这个是用来给一个玩家发牌的
		int count = 0;// 用来记录一个玩家得到的牌数

		for (;;) {
			Random r = new Random();
			int n = r.nextInt(52);
			int flag = 0;// 设一个标志，0代表这张牌之前没有发过

			for (int i = 0; i < re; i++) {// record数组，检查这张牌之前被发过没有
				if (record[i] == n)
					flag = 1;// 改成1，代表这张牌之前已经被发过
			}

			if (flag == 1)// 如果发现这牌已经被发过了
				continue;// 重新发新的一张牌
			else {
				record[totalCount++] = n;
				a.ownPoker[count] = new Poker(n);
				playerPoker[count] = a.ownPoker[count].kn;
				a.s = a.s + a.ownPoker[count].num;

			}

			if (totalCount == 11)// 如果四个玩家都发完了
				totalCount = 0;

			if (count == quaPokers - 1)// 如果一个玩家的牌发够了，就停
				// a=new
				// Player(a.name,playerPoker);//不能用左边这种方法重新计算a的s,a和赋进来的对象id不同，需手动赋值
				break;
			count++;

		}
	}

}
