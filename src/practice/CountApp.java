package practice;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountApp extends JFrame{
	
	JButton bt;
	JLabel la1, la2;
	
	public CountApp() {
		
		la1 = new JLabel("0");
		la2 = new JLabel("0");

		setLayout(new FlowLayout());
		// 크기가 어느정도인지 알아보기 위해 색깔을 줘보자
		la1.setBackground(Color.YELLOW);
		la2.setBackground(Color.YELLOW);
		
		//컴포넌트의 크기 억지로 키우기
		//la1.setPreferredSize(new Dimension(300, 380));
		
		la1.setFont(new Font("Dotum", Font.BOLD, 90));
		la2.setFont(new Font("Dotum", Font.BOLD, 90));
		
		add(la1);
		add(la2);
		
		setSize(700,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		new CountApp();
		
	}

}
