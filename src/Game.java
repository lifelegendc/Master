import java.util.*;

public class Game {
	static int quaPokers = 3;// ÿ������õ���������
	static int quaPlayers = 4;// �����
	static int re = quaPokers * quaPlayers;// һ����Ҫ��������
	int[] record = new int[re];// ������¼����������Щ��
	int[] playerPoker = new int[quaPokers];// ������¼һ����ҵõ�����

	int totalCount;// ������¼һ�����Ѿ���������
	Player[] ps = new Player[quaPlayers];

	Game() {
		for (int j = 0; j < quaPokers; j++) {
			playerPoker[j] = 0;
		}
		// ÿ�����󱻸�����ͬһ��palyPoker,����ownPokerָ����ͬ��
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

	void arangePokers(Player a) {// �����������һ����ҷ��Ƶ�
		int count = 0;// ������¼һ����ҵõ�������

		for (;;) {
			Random r = new Random();
			int n = r.nextInt(52);
			int flag = 0;// ��һ����־��0����������֮ǰû�з���

			for (int i = 0; i < re; i++) {// record���飬���������֮ǰ������û��
				if (record[i] == n)
					flag = 1;// �ĳ�1������������֮ǰ�Ѿ�������
			}

			if (flag == 1)// ������������Ѿ���������
				continue;// ���·��µ�һ����
			else {
				record[totalCount++] = n;
				a.ownPoker[count] = new Poker(n);
				playerPoker[count] = a.ownPoker[count].kn;
				a.s = a.s + a.ownPoker[count].num;

			}

			if (totalCount == 11)// ����ĸ���Ҷ�������
				totalCount = 0;

			if (count == quaPokers - 1)// ���һ����ҵ��Ʒ����ˣ���ͣ
				// a=new
				// Player(a.name,playerPoker);//������������ַ������¼���a��s,a�͸������Ķ���id��ͬ�����ֶ���ֵ
				break;
			count++;

		}
	}

}
