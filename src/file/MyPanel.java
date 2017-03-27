/*
 �г��� �󺧰� ��ư�� ������ �ִ�.
 Jpanel has Label & Button.
 
 �󺧰� ��ư�� �����Ǿ���
 */

package file;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	JLabel la;
	JButton bt;

	// �г��� �¾ �� �� ��ǰ�� ���� �¾�� �ϹǷ� �����ڿ��� �ʱ�ȭ����, ���� �̸��� �Ѱܹ���
	public MyPanel(String title, ImageIcon icon) {
		la = new JLabel(title);
		bt = new JButton(icon);

		bt.setBorderPainted(false); // ��ư�� ��輱 ���ֱ�
		bt.setContentAreaFilled(false); // ����Ʈ ������ ��ä��� ����
		bt.setFocusPainted(false); // ��Ŀ���� ���� �����ֱ�
		bt.setOpaque(false);// �������Ѱ�

		setLayout(new BorderLayout());
		add(la, BorderLayout.NORTH);
		add(bt, BorderLayout.CENTER);
	}
}
