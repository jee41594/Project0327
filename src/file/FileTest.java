/*
java���� ���͸��� �����ϱ� ���� Ŭ������ ������ �������� �ʰ�,
���͸��� ���Ϸ� �����Ѵ�.
��� : java.io.File Ŭ������ ����+���͸����� ó��

�ϳ��� �гο� ���� ��!
���� �����͸� ���������� �ٸ� �� ������ ��ü�� flowLayout
������ �гη� for�� ������!

fileExplorer

 */
package file;
import java.io.File;

public class FileTest {	
	public static void main(String[] args) {
		//C����̺��� ������ �����ϴ� ��� ���͸� �� ������ ����غ���!!
		
		File file = new File("C:/");
		
		//���� ���丮 �� ������ ��� ����
		//String[] dir = file.list(); ���͸� ��ܸ� �޴°��̷�
		File[] dir = file.listFiles(); 
		
		for(int i=0; i<dir.length; i++) {
			if(dir[i].isDirectory()){
				System.out.println(dir[i].getName());
			}	
		}
	}
}
