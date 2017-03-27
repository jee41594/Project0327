/*
FileInputStream ���� �����ڰ� ���ϴ� ������ ��Ʈ���� ������ �� ������
Ű����� ���� ǥ�� �Է� �ϵ������ ��쿣 �ڹٰ� ��Ʈ���� �������� ���ϰ�
�ش� OS�� �����ϹǷ� �ڹ� �����ڴ� OS�κ��� ǥ���Է� ��Ʈ���� ���;� �Ѵ�.

�ڹ��� Ŭ���� �� SystemŬ������ static ������� �� 
�� has a ����� ������ InputStream�� in��ü�� �ٷ� ǥ���Է½�Ʈ���� �޾Ƴ��� Ŭ�����̴�.
���� ���ÿ� System.in;

���ڱ�� ��Ʈ�� Ŭ������ �̸� ��Ģ
�Է� : ~~Reader
��� : ~~Writer
Reader/Writer ������ �ȱ�����!
*/
package io;

import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class KeyBoardApp{


	public static void main(String[] args) {
		InputStream is = System.in;

		//���ڱ�� ��Ʈ���� �ܵ����� �����ϴ� ���� �ƴ϶�
		//�̹� Byte ��� ��Ʈ���� ������ �Ѵ�. ���� ������ ��������
		//�μ��� ����Ʈ ��� ��Ʈ���� �ִ´�.

		InputStreamReader reader=null;
		reader = new InputStreamReader(is);
		
		int data;
		try{
			while(true) {
				//data = is.read(); //1. 1byte�о���� -> �ѱ��� ����
				data = reader.read();// 2. ���� 2byte���� �� �ִ�.

				//System.out.print((char)data); 1.�̷����ϸ� a�����. 1byte�������Ƿ� ���Ͷ� Ŀ���� �ȳ��� -> while���ʿ�!
				//System.out.print((char)data);  1.����ϸ� ���ڷ� ����! 13�� 10�� ��𰡰� a�� ��������?
				//13�� ����� ����ϹǷ� ǥ���� �ȵ�,,!!��ġ�� ȿ���� �����ִ�.
				//System.out.print(data); 2. ���� reader.raad���ϸ� �۾� �б� ����!! 2byte�� ������ �����Ƿ�
				System.out.print((char)data); //2. ���� ����� �������� 13,14�� �������� ������x
			}

		} catch(IOException e) {
			
		}


		


	}

}
