/*
 �簢���� ǥ���� ��ü �� �� ������
 */

package homework;

import java.awt.Color;
import java.awt.Graphics;

public class RectThread extends ShapeThread{
	
	public RectThread(int x, int y, int width, int height, int interval, Graphics g) {
		super(x, y, width, height, interval, g);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void render() {
		g.setColor(Color.pink);
		g.fillRect(0, 0, 700, 600);
		
		//���ϴ� ���� �׸���
		g.setColor(Color.RED);
		x+=20;
		g.drawRect(x, y, width, height);
	}

}
