package practice;

import javax.swing.JLabel;

public class CountThread extends Thread{
	
	JLabel la;
	int interval;
	int count;
	
	public CountThread(JLabel la, int interval) {
		this.la =la;
		this.interval =interval;
		
	}
	
	public void run() {
		
		try {
			Thread.sleep(interval);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count++;
		la.setText(Integer.toString(count));
	}

}
