package thread;

public class OvalThread extends Thread{
	
	AniOval aniOval;

	public OvalThread(AniOval aniOval) {
		this.aniOval = aniOval;
	}
	
	public void run() {
		// 끝나지 않고 호출해야 한다. AniMain의 move를 가져와야한다.
		while(true){ //이렇게하면 너무나 빨리돌아서 인간의 눈으로 볼 수가 없다. 휴가보내야 한다.
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			aniOval.move();			
		}

	}

}