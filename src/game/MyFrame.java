package game;

import javax.swing.JFrame;//导入java环境以提供好的窗体类JFrame

public class MyFrame {
	public static final int WIDTH=707;//窗体宽度
	public static final int HEIGHT=730;//窗体高度

	public static void main(String[] args) {
//		新建一个窗体对象，把该窗体对象（在内存中的起始地址）赋给变量frame
//		以后我们通过哦frame来操作刚刚新建的窗体
		JFrame frame=new JFrame();
		frame.setSize(WIDTH,HEIGHT);
		frame.setTitle("拼图游戏");//定义窗体标题名称
		frame.setResizable(false);//设置窗体大小不可改变
		//设置窗口相对谁的位置，若NULL，则相对屏幕定位在屏幕中间，即居中
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体默认关闭行为，默认窗体关闭时退出程序
		MyPanel panel=new MyPanel();//创建MyPanel对象
		frame.add(panel);//在窗体上添加面板
		frame.setVisible(true);//显示窗体	
	}
}
