package homework2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountApp extends JFrame{
	JLabel la1, la2;

	public CountApp() {
		la1 = new JLabel("0");
		la2 = new JLabel("0");

		setLayout(new FlowLayout());
		// ũ�Ⱑ ����������� �˾ƺ��� ���� ������ �ຸ��
		la1.setBackground(Color.YELLOW);
		la2.setBackground(Color.YELLOW);
		
		//������Ʈ�� ũ�� ������ Ű���
		//la1.setPreferredSize(new Dimension(300, 380));
		
		la1.setFont(new Font("Dotum", Font.BOLD, 90));
		la2.setFont(new Font("Dotum", Font.BOLD, 90));
		
		add(la1);
		add(la2);
		
		//������ 2�� �����ϱ�
		CountThread ct1 = new CountThread(la1, 5);
		CountThread ct2 = new CountThread(la2, 500);
		
		setSize(700,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new CountApp();
	}
	

}
