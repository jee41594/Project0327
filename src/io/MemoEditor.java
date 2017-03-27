/*
 <����>
 ���۽�Ʈ�� : ���پ� �о���� �� �־���? �ӵ� ����� ���ؼ�!
 ����ó����ɵ� �����鼭 �ѱ۵� �ȱ����� ����? BufferedReader
 
 BufferedReader(Reader in)  -> Reader ��Ƹ��� �� �ִ�.
 
 ------------------------------------------------------------------
<����>
BufferedReader ����
�ٸ��͵� �Ẹ��! 	writer2 = new PrintWriter(fos); ������ ������ �̰ž���.

ImageIcon �����µ� inteface 
�ٽ� Ȯ���غ��� ImageIcon ���� new�� �����ϴ�.


 */

package io;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoEditor extends JFrame {

	JPanel p_north;
	JButton bt_open, bt_save;
	ImageIcon icon;
	JTextArea area;
	JScrollPane scroll;
	String ori = "C:/java_workspace2/Project0327/res/memo.txt"; // ����
	String dest = "C:/java_workspace2/Project0327/res/memo_copy.txt"; // �ٸ� ������ ������
	FileInputStream fis;
	FileOutputStream fos;

	InputStreamReader reader; // ���ڱ���� �Է½�Ʈ��!
	BufferedReader buffr; // ����ó���� ���ڱ�� �Է½�Ʈ��-> ���û��������� 
	
	//���ڱ���� ��½�Ʈ��
	OutputStreamWriter writer;
	PrintWriter writer2; //���ڱ���� ��½�Ʈ��

	public MemoEditor() {

		p_north = new JPanel();
		icon = new ImageIcon("C:/java_workspace2/Project0327/res/folder_on.png");
		bt_open = new JButton(icon);
		bt_save = new JButton("����");
		area = new JTextArea();
		scroll = new JScrollPane(area);  

		p_north.add(bt_open);
		p_north.add(bt_save);

		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		bt_open.setBorderPainted(false);
		bt_open.setContentAreaFilled(false);
		bt_open.setFocusPainted(false);
		bt_open.setOpaque(false);
		this.setPreferredSize(new Dimension(10, 10));

		// ��ư 2�� �����͸����� �ޱ� ����, �����ϱ�
		bt_open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});

		bt_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});

		setSize(700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// ���� ���� ��������
	public void open() {

		try {
			fis = new FileInputStream(ori);
			// ���ڱ�� ��Ʈ������ �������ڵ� �Ӽ��� ������ �� �ִ�.
			reader = new InputStreamReader(fis, "utf-8"); // fis�� ��Ƹ���
			buffr = new BufferedReader(reader); //3���ڸ� �Ǻ��� �Ǿ��ٰ� ��������!

			//int data;
			String data; //���̻� int�ƴϹǷ�
			int count=0; //read�� Ƚ���� �˱�����!

			while (true) {
				// data = fis.read(); ->1byte
				//data = reader.read(); ���� 2byte
				data = buffr.readLine();  //������ �о�帮�µ� byte ���� ���ϹǷ� �޼��尡 �ʿ��ϴ�. -> reaLing String���� ��ȯ
				count++;
				//if (data == -1)
				if (data == null) //null�� �� ������ �ٲ��.
					break;
				// append�� String�� ���Ѵ� �׷� ���? WrapperŬ���� �̿�!
				// Integer.toString(data)???? �ȵȴ�.
				//area.append(Character.toString((char)data)); 
				area.append(data+"\n"); //String���� ��ȯ�����Ƿ� ���̻� ����ȯ �ʿ�x but �츮�� �ٹٲ� ǥ��������Ѵ�.
			} System.out.println("count="+ count); //���پ� ������ �� �ٰ��̴�!

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "������ �������� �ʽ��ϴ�");
			e.printStackTrace(); // �����ڸ� ���� �α�����! stack���� ����! �̰� ����� ������ �Ⱥ���
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// �����ϱ�
	public void save() {
		try{
			//FileOutputStream�� ������ ����� ������ �����ع�����.
			//ũ��� 0����Ʈ�� empty������
			fos = new FileOutputStream(dest);
			//writer = new OutputStreamWriter(fos, "utf-8");		
			writer2 = new PrintWriter(fos); 
			writer2.write(area.getText());

		} catch(FileNotFoundException e) {
			e.printStackTrace();
			
		/*} catch (UnsupportedEncodingException e) {
			JOptionPane.showMessageDialog(this, "�������� �ʴ� ������ ���ڵ��Դϴ�");
			e.printStackTrace();  PrintWriter �� �̰� ���ʿ� ����.*/  
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "����½� ���� �߻�");
			e.printStackTrace();
		} finally{
			//������� ��Ʈ���� ���� �ݴ� ó��
			//��������� �ϳ��� �ݴ´�. ������ �߿����� ������ �ٱ����� ����.
			if(writer2!=null){
				/*try {
					writer2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}	PrintWriter �� �̰� ���ʿ� ����. */	
				writer2.close();
			}
			
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}		
			}
		}
	}

	public static void main(String[] args) {
		new MemoEditor();
	}
}
