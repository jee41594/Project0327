package progressbar;

import javax.swing.JProgressBar;

public class BarThread extends Thread{
	
	JProgressBar bar;
	int interval;
	int count;
	
	public BarThread (JProgressBar bar, int interval) {
		this.bar = bar;
		this.interval = interval;
		this.start();
		
	}

	public void run() {
		
		while(true){
			try {
					Thread.sleep(interval);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				count++;
				bar.setValue(count);
			}
	}

}
