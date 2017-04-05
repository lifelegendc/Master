import java.awt.Graphics;

public class Poker {

	int kn;// ��ɫ�����֣�0-12Ϊ���ң�13-25Ϊ���ң�26-38Ϊ���飬39-51Ϊ÷��
	String kind;// ��ɫ
	int num;// ����

	Poker(int kn) {
		this.kn = kn;
		switch (this.kn / 13) {
		case 0:// ��ס0����1����0
			kind = "����";
			break;
		case 1:
			kind = "����";
			break;
		case 2:
			kind = "����";
			break;
		case 3:
			kind = "÷��";
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
