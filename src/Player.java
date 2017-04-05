public class Player {
	String name;
	int num1 = Game.quaPokers;// 每个玩家获得牌的张数
	Poker[] ownPoker = new Poker[num1];// 数字为0-51
	int s = 0;// 牌数字的总和

	Player(String name, int p[]) {
		for (int i = 0; i < num1; i++) {
			ownPoker[i] = new Poker(0);
			ownPoker[i].num = 0;
		}

		this.name = name;
		// ownPoker = p;//跟下面的不同，这样两个数组的id会变成一样的，最后导致所有player共用同一个ownPoker
		for (int i = 0; i < num1; i++) {
			ownPoker[i] = new Poker(p[i]);// 这是按元素赋值，两个数组的id不同// ownPoker[i].kn
											// = p[i];
			s = ownPoker[i].num + s;
		}

	}

	Player compare(Player ano) {
		if (this.s >= ano.s)
			return this;
		else
			return ano;
	}

	public String toString() {
		return this.name;
	}

}
