public class Player {
	String name;
	int num1 = Game.quaPokers;// ÿ����һ���Ƶ�����
	Poker[] ownPoker = new Poker[num1];// ����Ϊ0-51
	int s = 0;// �����ֵ��ܺ�

	Player(String name, int p[]) {
		for (int i = 0; i < num1; i++) {
			ownPoker[i] = new Poker(0);
			ownPoker[i].num = 0;
		}

		this.name = name;
		// ownPoker = p;//������Ĳ�ͬ���������������id����һ���ģ����������player����ͬһ��ownPoker
		for (int i = 0; i < num1; i++) {
			ownPoker[i] = new Poker(p[i]);// ���ǰ�Ԫ�ظ�ֵ�����������id��ͬ// ownPoker[i].kn
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
