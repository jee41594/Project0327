/*
 프로그레스바를 3개 띄운다음에 작동을 누르면
 서로다른 속도로 증가해야 한다.
 쓰레드 3개 필요!?
 
 */
package progressbar;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBarTest extends JFrame {

	// JProgressBar bar1, bar2, bar3;
	// 배열로 해보자
	JProgressBar[] bar = new JProgressBar[3];
	MyBar[] mb = new MyBar[3];
	int[] interval = { 100, 500, 1000 };
	JButton bt;
	// int count=0;

	public ProgressBarTest() {

		/*
		 * bar1 = new JProgressBar(); bar2 = new JProgressBar(); bar3 = new
		 * JProgressBar();
		 */

		setLayout(new FlowLayout());

		bt = new JButton("작동");

		/*
		 * bar1.setPreferredSize(new Dimension(450, 40));
		 * bar2.setPreferredSize(new Dimension(450, 40));
		 * bar3.setPreferredSize(new Dimension(450, 40));
		 */

		add(bt);

		/*
		 * add(bar1); add(bar2); add(bar3);
		 */

		bt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				create();
			}
		});

		setVisible(true);
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void create() {

		for (int i = 0; i < bar.length; i++) {
			bar[i] = new JProgressBar();
			mb[i] = new MyBar(bar[i], interval[i]);
			bar[i].setPreferredSize(new Dimension(450, 40));
			add(bar[i]);
		}
	}
	/*
	 * MyBar bt1 = new MyBar(bar1, 1000);
	 * 
	 * MyBar bt2 = new MyBar(bar2, 500); 
	 * MyBar bt3 = new MyBar(bar3, 1000);
	 */
	/*
	 * BarThread bt1 = new BarThread(bar1, 1000); 
	 * BarThread bt2 = new BarThread(bar2, 500); 
	 * BarThread bt3 = new BarThread(bar3, 1000);
	 */

	public static void main(String[] args) {
		new ProgressBarTest();
	}

}
