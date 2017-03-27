/*
 ������ ������ �� ũ�⸦ �����Ϸ��� �ڵ尡 �����ϹǷ�
 ������ ���밡�ɼ��� �����صΰ� ������ ������ �̹��� ��������
 ���� �����غ���.
 */

package file;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class MyIcon extends ImageIcon{
	
	//�갡 �¾�� MyIcon����	
	public MyIcon(URL url, int width, int height) {
		//URL url = this.getClass().getResource("/folder_on.png") ��� ���� ����
		//���� �¾��Ǵϱ� ���̻� new�� ����.
		super(url);

		Image scaledImg = this.getImage();
		//ũ�⸦ �������� �� ��������� �̹��� ��ü�� 
		Image result = scaledImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		this.setImage(result);
	}
}
