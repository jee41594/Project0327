package thread;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AniOval extends JFrame{
	
	JButton bt;
	AniOval aniOval;
	OvalThread ot;
	MyOval can;

	public AniOval() {
		aniOval = this;
		
		bt = new JButton("물체이동");
		add(bt, BorderLayout.NORTH);
		
		//can = new MyOval(this.getClass());
		
		can.setBackground(Color.pink);
		add(can);
		
		bt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ot = new OvalThread(aniOval);
				ot.start();
			}
		});
		
		setSize(300,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void move() {
		//x+=5;
		can.repaint();
	}

	public static void main(String[] args) {
		new AniOval();
	}

}
