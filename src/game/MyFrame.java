package game;

import javax.swing.JFrame;//����java�������ṩ�õĴ�����JFrame

public class MyFrame {
	public static final int WIDTH=707;//������
	public static final int HEIGHT=730;//����߶�

	public static void main(String[] args) {
//		�½�һ��������󣬰Ѹô���������ڴ��е���ʼ��ַ����������frame
//		�Ժ�����ͨ��Ŷframe�������ո��½��Ĵ���
		JFrame frame=new JFrame();
		frame.setSize(WIDTH,HEIGHT);
		frame.setTitle("ƴͼ��Ϸ");//���崰���������
		frame.setResizable(false);//���ô����С���ɸı�
		//���ô������˭��λ�ã���NULL���������Ļ��λ����Ļ�м䣬������
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���Ĭ�Ϲر���Ϊ��Ĭ�ϴ���ر�ʱ�˳�����
		MyPanel panel=new MyPanel();//����MyPanel����
		frame.add(panel);//�ڴ�����������
		frame.setVisible(true);//��ʾ����	
	}
}
