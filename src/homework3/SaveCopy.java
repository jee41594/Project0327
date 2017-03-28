/*
 �Ϸ�ɶ�����! .. ? �����?
 file.length() -> //���Ͽ뷮��ŭ
 �����뷮 ���Ϸ���...? %���?
 ��� �޾ƿ°� sum�ؼ�
 
 ���� ��ü�� 286byte���...!!??
 286 : 100 = 5:x;
 286x = 500
 x = 100% * ���� ������ / ������ü�뷮
 
 ��ư�� ������ thread�� ���� fileStream�� �����ϴ°�!
 */

package homework3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class SaveCopy extends JFrame implements ActionListener{
	JProgressBar bar;
	JButton bt_open, bt_save, bt_copy;
	JTextField t_open, t_save;
	JFileChooser chooser;
	FileInputStream fis;
	FileOutputStream fos;
	Thread thread;
	int count;
	int data;
	
	public SaveCopy() {
		

		

		bar = new JProgressBar();
		bt_open = new JButton("����");
		bt_save = new JButton("������ ��");
		bt_copy = new JButton("����");
		t_open = new JTextField(30);
		t_save = new JTextField(30);
		
		chooser = new JFileChooser("C:/java_workspace2/Project0323");
		
		setLayout(new FlowLayout());
		
		bar.setPreferredSize(new Dimension(400, 40));
		add(bar);
		add(bt_open);
		add(t_open);
		add(bt_save);
		add(t_save);
		add(bt_copy);
		
		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_copy.addActionListener(this);

		setSize(475, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	public void actionPerformed(ActionEvent e){
		
		Object obj = e.getSource();
		
		if(obj==bt_open){
			open();			
		}else if(obj==bt_save){
			save();			
		}else if(obj==bt_copy){
			copy();			
		}
	}
	
	public void open() {
		
		int state = chooser.showOpenDialog(this);
		if(state == JFileChooser.APPROVE_OPTION){
			File file= chooser.getSelectedFile();
			String path = file.getAbsolutePath();
			t_open.setText(path);
		}
	}
	
	public void save() {
		
		int state = chooser.showOpenDialog(this);
		if(state == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			String path = file.getAbsolutePath();
			t_save.setText(path);			
		}
	}
	
	public void copy() {

		String oriPath = t_open.getText();
		String newPath = t_save.getText();
		
		//bar�� �����Ѵ�. ����Ÿ �б� ������
		thread = new Thread(){

			public void run() {
				while(data==0){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					count++;
					bar.setValue(count);
				}
			}		
		};
		
		try {
			fis = new FileInputStream(oriPath);
			fos =new FileOutputStream(newPath);
			
			while(true){
				data = fis.read();

				if(data==-1)break;
				fos.write(data);
			}
			JOptionPane.showMessageDialog(this, "����Ϸ�");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "������ ã�� �� �����ϴ�");	
			e.printStackTrace();
		} catch(IOException e) {
			JOptionPane.showMessageDialog(this, "IO�۾��� ������ �߻��߽���");		
			
		}finally{
			try{
				if(fis!=null){
					fis.close();
				}
				if(fos!=null){
					fos.close();
				}
			} catch(IOException e) {			
			}
		}	
		

	}
	

	public static void main(String[] args) {
		new SaveCopy();
		
	}

}
