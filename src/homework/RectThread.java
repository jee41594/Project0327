/*
 사각형을 표현한 객체 및 그 움직임
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
		
		//원하는 도형 그리기
		g.setColor(Color.RED);
		x+=20;
		g.drawRect(x, y, width, height);
	}

}
