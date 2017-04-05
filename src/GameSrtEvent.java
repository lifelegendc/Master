import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class GameSrtEvent extends Applet implements ActionListener {
	Button btn;
	Game g1;
	StringBuffer loc;// 记录图片位置
	Label b[] = new Label[6];

	public void init() {
		setLayout(null);
		btn = new Button("Play");
		btn.addActionListener(this);
		setSize(2000, 2000);
		for (int i = 0, y = 750; i < 6; i++) {
			b[i] = new Label(" ");
			b[i].setBounds(100, y, 550, 30);
			b[i].setFont(new Font("", 1, 20));// 设置字体大小
			add(b[i]);
			y = y + 30;
		}
		add(btn);
		btn.setBounds(1600, 750, 50, 50);
		g1 = new Game();
		b[5].setText("游戏规则：不看花色，每张牌的数字和最大的玩家为赢家");
		b[5].setBounds(100, 700, 550, 30);
		b[4].setForeground(Color.RED);// 设置字体颜色
	}

	public void paint(Graphics g) { // 将图片显示到java'小程序域
		int y = 50;
		for (int j = 0; j < Game.quaPlayers; j++) {
			int x = 500;
			if (j == 1)
				x = 10;
			if (j == 2)
				x = 990;
			for (int i = 0; i < Game.quaPokers; i++) {
				StringBuffer loc = new StringBuffer(
						"D:\\java\\PokerGamePicVer\\pokerPICs\\");// 记录图片位置
				loc.append(g1.ps[j].ownPoker[i].kn + ".jpg");
				x = x + 150;
				if (j == 1 || j == 2)
					y = 400;
				g.drawImage(getToolkit().getImage(loc.toString()), x, y, this);
			}
			y = y + 350;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			for (int i = 0; i < g1.quaPlayers; i++) {
				g1.arangePokers(g1.ps[i]);
				b[i].setText("玩家" + g1.ps[i].name + "获得的三张牌:"
						+ g1.ps[i].ownPoker[0].num + " "
						+ g1.ps[i].ownPoker[1].num + " "
						+ g1.ps[i].ownPoker[2].num + " 总和为：" + g1.ps[i].s);

			}
			b[4].setText("The best winner is:   "
					+ ((g1.ps[0].compare(g1.ps[1])).compare(g1.ps[2]))
							.compare(g1.ps[3]).name + "  Congratulations!");

			for (int i = 0; i < g1.quaPlayers; i++) {
				g1.ps[i].s = 0;// 每轮记得清零
			}
			repaint();
		}

	}

}
