package game;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements MouseListener{
	public int w=MyFrame.WIDTH-7;	//面板（可做图区域）宽
	public int h=MyFrame.HEIGHT-30;//面板（可做图区域）高
	int time=0;
	JButton[] btns={new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),
			new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),
			new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),
			new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),
			new JButton(),new JButton(),new JButton(),new JButton(),new JButton() };//新建25个按钮
	
	ImageIcon[] icons={new ImageIcon("src/game/ai_01.jpg"),new ImageIcon("src/game/ai_02.jpg"),new ImageIcon("src/game/ai_03.jpg"),
			new ImageIcon("src/game/ai_04.jpg"),new ImageIcon("src/game/ai_05.jpg"),new ImageIcon("src/game/ai_06.jpg"),
			new ImageIcon("src/game/ai_07.jpg"),new ImageIcon("src/game/ai_08.jpg"),new ImageIcon("src/game/ai_09.jpg"),
			new ImageIcon("src/game/ai_10.jpg"),new ImageIcon("src/game/ai_11.jpg"),new ImageIcon("src/game/ai_12.jpg"),
			new ImageIcon("src/game/ai_13.jpg"),new ImageIcon("src/game/ai_14.jpg"),new ImageIcon("src/game/ai_15.jpg"),
			new ImageIcon("src/game/ai_16.jpg"),new ImageIcon("src/game/ai_17.jpg"),new ImageIcon("src/game/ai_18.jpg"),
			new ImageIcon("src/game/ai_19.jpg"),new ImageIcon("src/game/ai_20.jpg"),new ImageIcon("src/game/ai_21.jpg"),
			new ImageIcon("src/game/ai_22.jpg"),new ImageIcon("src/game/ai_23.jpg"),new ImageIcon("src/game/ai_24.jpg"),null};//24个图片，最后一张为空
	public int[][] order={ {14,12,10,5,1,7,4,3,0,13,9,6,8,2,11,15,16,17,18,19,20,21,22,23,24},
	{9,6,3,12,13,2,8,4,1,0,15,7,11,14,5,10,15,16,17,18,19,20,21,22,23,24} };//用于图片随即打乱顺序

	long startTime = System.currentTimeMillis();    //获取开始时间

	public MyPanel() {
		//		JButton btn1=new JButton();//新建按钮对象
		//		btn1.setIcon(new ImageIcon("0.jpg"));//按钮btn1添加文字
		//		this.add(btn1);//将按钮添加到画布上		
		setLayout(new GridLayout(5, 5));//建立面板布局，表格形式，规范为几行几列
		
		int n=(int)(Math.random()*2);
		for(int i=0;i<25;i++){
			btns[i].setIcon(icons[ order[0][i] ]);//设置按钮上的图片
			this.add(btns[i]);//添加按钮到面板上
			btns[i].addMouseListener(this);//对每一个按钮进行鼠标监听
		}
	}

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		//1.得到单击的按钮的名称
		int n=-1;
		for(int i=0;i<25;i++){
			if(e.getSource()==btns[i]){
				n=i;
				break;
			}
		}
		
		//2.处理各个方向的移动
//		0 1 2
//		3 4 5
//		6 7 8
//		2.1向上
		for(int i=-1;i<2;i+=2){
			if((n+i*5<=24) && (n+i*5>=0) && btns[n+i*5].getIcon()==null){//上下位移
				btns[n+i*5].setIcon(btns[n].getIcon());
				btns[n].setIcon(null);
				System.out.println("第"+ ++time+"步");//有效单击
			}
			else if((n+i<=24) &&(n+i>=0) && btns[n+i].getIcon()==null){//左右位移
				btns[n+i].setIcon(btns[n].getIcon());
				btns[n].setIcon(null);
				System.out.println("第"+ ++time+"步");
			}
		}
		//判断是否成功
		boolean isSuccess=true;//没有价值
		for(int i=0;i<25;i++){
			if(btns[i].getIcon() != icons[i])
				return;
		}
		//调用选项面板，弹出一个消息对话框
		//第一个参数表示对话框在哪一个窗口里弹出，若填null
		//则表示在当前窗口中弹出
		System.out.println("恭喜过关！");
		long endTime = System.currentTimeMillis();    //获取结束时间
		System.out.println("所用时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
		JOptionPane.showMessageDialog(null, "恭喜过关！\n"+"所用时间：" + (endTime - startTime) + "ms");
//		for(int i=0,j=0;i<9;i++){
//			if(btns[i].getIcon()==icons[i])
//				j++;
//			if(j>=8){
//				System.out.println("恭喜过关！");
//				return;
//			}
//		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根

	}
}
