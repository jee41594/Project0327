package homework3;

import javax.swing.JProgressBar;

public class CopyThread extends Thread{
	
	JProgressBar bar;
	int count;
	
	public CopyThread() {
		start();
		
	}
	
	public void run() {
	/*	
		while(){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			bar.setValue(count);
		}*/
	}
}
