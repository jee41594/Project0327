package thread;

public class OvalThread extends Thread{
	
	AniOval aniOval;

	public OvalThread(AniOval aniOval) {
		this.aniOval = aniOval;
	}
	
	public void run() {
		// ������ �ʰ� ȣ���ؾ� �Ѵ�. AniMain�� move�� �����;��Ѵ�.
		while(true){ //�̷����ϸ� �ʹ��� �������Ƽ� �ΰ��� ������ �� ���� ����. �ް������� �Ѵ�.
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			aniOval.move();			
		}

	}

}