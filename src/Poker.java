import java.awt.Graphics;

public class Poker {

	int kn;// 花色加数字，0-12为黑桃，13-25为红桃，26-38为方块，39-51为梅花
	String kind;// 花色
	int num;// 数字

	Poker(int kn) {
		this.kn = kn;
		switch (this.kn / 13) {
		case 0:// 记住0除以1等于0
			kind = "黑桃";
			break;
		case 1:
			kind = "红桃";
			break;
		case 2:
			kind = "方块";
			break;
		case 3:
			kind = "梅花";
			break;
		default:
			break;
		}
		num = kn % 13;
		if (num == 0) {
			num = 1 + kn % 13;
			if (kn != 0)
				num = 13 + kn % 13;
		}
	}

	public String toString() {
		return kind + num;
	}

}
