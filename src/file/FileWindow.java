/*
 Ŭ������ �ڵ��� ���붧���� ���� ����̴�.
 1. ������ ������ ����� �ٴ��� Ȯ���غ���.
 
 <tip>
  ��θ� c ����̺곪 d����̺꿡 �������� ���� ���� ������Ʈ ���������ؼ�
  �����ϴ� ����� �ִ�. -> res ���͸��� classpath�� �����
  java���� classpath���� img�� ���� �� �ִ�.
  res�����ʹ�ư build path -> use
  
 url = Uniformed Resource Locator - ���յ� �ڿ��� ��ġ!
 
 2. ��ưŬ���� ���? for�������� �ذ��Ѵ�.
 ���� ������ �� for������ �ϳ��� �����. 
 ������? �ƴϿ� -> ���� img
 
  */

package file;

import java.awt.FlowLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;

public class FileWindow extends JFrame{
	
	MyIcon folder_on, folder_off;
	
	public FileWindow() {
		
		setLayout(new FlowLayout());
		
		//�̹��� �������� �����ϵ� res �����κ���	
		folder_on = new MyIcon(this.getClass().getResource("/folder_on.png"),50,50);
		folder_off = new MyIcon(this.getClass().getResource("/folder_off.png"),50,50);
		
/*
 		//URL url = this.getClass().getResource("/folder_on.png") ��� ���� ����

		Image scaledImg = folder_on.getImage();
		//ũ�⸦ �������� �� ��������� �̹��� ��ü�� 
		Image result = scaledImg.getScaledInstance(50, 50, SCALE_SMOOTH);
		folder_on.setImage(result);		
 */

		//����� �ٴ��� �׽�Ʈ�غ���.
		ArrayList<String> list = getDirList();
		for(int i=0; i<list.size(); i++){
			String dirName = list.get(i);
			MyPanel mp = new MyPanel(dirName, folder_off);
			add(mp);
		}
	
		setVisible(true);
		setSize(600,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}

	//���ϴ� ����� ���� ���͸� �� ���� ���ϱ�
	public ArrayList getDirList() {
		//���� ���� ���⿣ ���͸��� ������ ���� �ִ� ��󳻾���!!
		File file = new File("C:/");
		File[] fileList = file.listFiles();
		
		//�迭�� ������? ũ�⸦ ������� �ʾƵ� �þ�� �Ҽ����� ������ ����! String�� ���� �� �ִ�.
		ArrayList<String> dirList = new ArrayList<String>(); 
		
		//���͸��� �����
		for(int i=0; i<fileList.length; i++){
			if(fileList[i].isDirectory()) {
				//���͸��� �߰ߵ� ������ dirList�� �߰�
				dirList.add(fileList[i].getName()); //fileList�� i��°�� ���͸����� ����!						
			}	
		}
		return dirList;
	}
	
	public static void main(String[] args) {
		new FileWindow();
		
	}

}
