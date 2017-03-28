/*
 완료될때까지! .. ? 산수로?
 file.length() -> //파일용량만큼
 남은용량 구하려면...? %계산?
 계속 받아온걸 sum해서
 
 파일 전체가 286byte라면...!!??
 286 : 100 = 5:x;
 286x = 500
 x = 100% * 내가 읽은것 / 파일전체용량
 
 버튼을 누르면 thread에 의해 fileStream도 제어하는것!
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
		bt_open = new JButton("열기");
		bt_save = new JButton("저장할 곳");
		bt_copy = new JButton("실행");
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
		
		//bar가 증가한다. 데이타 읽기 전까지
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
			JOptionPane.showMessageDialog(this, "복사완료");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "파일을 찾을 수 없습니다");	
			e.printStackTrace();
		} catch(IOException e) {
			JOptionPane.showMessageDialog(this, "IO작업중 에러가 발생했습니");		
			
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
