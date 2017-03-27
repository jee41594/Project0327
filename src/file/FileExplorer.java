/*

for���� ���������� ��ư(�̹���)�� �����Ǿ��ϴµ�, ���������� �������־�

�ϳ��� �гο� ���� ��!
���� �����͸� ���������� �ٸ� �� ������
��ü�� flowLayout
������ �гη� for�� ������!

���۳�Ʈ�� Ŀ���͸���¡�ߴ�.
������г��� ��ư���������ְ� �󺧵� ������ �ִ� - > has a ����!

*/
package file;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileExplorer extends JFrame {

	JPanel p_north, p_center;
	ImageIcon icon;
	JButton bt;
	JLabel lb;

	public FileExplorer() {

		p_north = new JPanel();
		p_center = new JPanel();

		File file = new File("C:/java_workspace2/Project0327");
		File[] dir = file.listFiles();

		for (int i = 0; i<dir.length; i++) {
			if (dir[i].isDirectory()) {
				
				icon = new ImageIcon("C:/java_workspace2/Project0327/res/folder_off.png");
				bt = new JButton(icon);
				lb = new JLabel();
				
				lb.setText(dir[i].getName());
				
				p_north.add(lb);
				p_north.add(bt);

			}
		}
		
		add(p_north, BorderLayout.NORTH);
		add(p_center, BorderLayout.CENTER);

		bt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				change();
			}
		}); 

		bt.setBorderPainted(false);
		bt.setContentAreaFilled(false);
		bt.setFocusPainted(false);
		bt.setOpaque(false);
		this.setPreferredSize(new Dimension(10, 10));

		setLayout(new FlowLayout());
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	public void create() {
	
	}
	
	public  void change() {
		
	}

	public static void main(String[] args) {
		new FileExplorer();
	}

}
