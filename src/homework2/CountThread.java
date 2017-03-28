/*
 * 
 */

package homework2;

import javax.swing.JLabel;

public class CountThread extends Thread{
	JLabel la;
	int interval;
	int count;
	
	//누군가가 클래스를 new 할때 원하는 라벨과 원하는 속도만 넘겨주면 된다.
	public CountThread(JLabel la, int interval) {
		this.la = la;
		this.interval = interval;
		this.start(); //여기서 start 때리자
	}

	public void run() {
		
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//특정 라벨의 값을 1씩 증가시키되 지정한 속도대로
			count++;
			//여기에 count 넣을 수 없다. 얘가 원하는 것은 String이므로 Wrapper클래스 필요!
			la.setText(Integer.toString(count));
		}

	}

}
