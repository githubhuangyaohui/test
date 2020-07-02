package Game;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI implements ActionListener{
	//创建主窗口
	JFrame jframe;
	//面板
	JPanel jpanel;
	JPanel jpanel2;
	//迭代次数
	int count=0;
	//绘图工具
	Graphics g;
	JButton button;
	JButton button2;
	//二维矩阵记录元胞变化
	Cell [][]cell;
	
	GUI() {
		//窗口初始化
		jframe=new JFrame();
    	jframe.setSize(480,460);
    	jpanel = new JPanel();
    	jpanel.setBounds(0, 0, 400, 400);
    	jpanel.setLayout(null);
    	//主窗口设置
    	jframe.setTitle("这是第"+count+"次演化");
    	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jframe.setLocationRelativeTo(null);
    	jframe.getContentPane().setLayout(null);
    	jframe.getContentPane().add(jpanel);
    	//主面板设置
    	jpanel2=new JPanel();
    	jpanel2.setBounds(400, 0, 60, 400);
    	jpanel2.setLayout(null);
    	
    	button = new JButton("开始");
    	button.setBounds(0, 0, 60, 60);
    	jpanel2.add(button);    	
    	
    	button2 = new JButton("生成");
    	button2.setBounds(0, 60, 60, 60);
    	jpanel2.add(button2);
    	
    	jframe.getContentPane().add(jpanel2);
    	jframe.setVisible(true);
    }
	//画出图像
	public void drawCell(Cell[][] cell) {
		jframe.setTitle("这是第"+count+"次演化");
		for(int i=0;i<16;i++) {
    		for(int j=0;j<16;j++) {
    			g.setColor(Color.WHITE);
    			g.fillRect(i*25, j*25, 25, 25);
    			g.setColor(Color.BLACK);
    			g.drawRect(i*25, j*25, 25, 25);
    		}
    	}
    	for(int i=0;i<16;i++) {
    		for(int j=0;j<16;j++) {
    			if(cell[i][j].getStatus()==1) {
    				g.setColor(Color.BLACK);
    				g.fillRect(i*25, j*25, 25, 25);
    			}
    		}
    	}
    	 count++;
	}
	//开始迭代
	public void StartPrint(Cell[][] cell) {
		long d1= System.currentTimeMillis();
    	while(true) {
    		long d2= System.currentTimeMillis();
    		if(d2-d1>100) {
    			int change;
    			d1=d2;
    			change=Map.Update(cell);
    			Map.getLivings(cell);
    			//画图
    			drawCell(cell);
    			if(change==16*16) break;
    			if(count>1000) break;
    	    }	    	
      }
    	JOptionPane.showMessageDialog(jframe, "在第"+count+"次演化达到平衡", "提示", JOptionPane.PLAIN_MESSAGE);
	}
	
	//开始运行程序
	public void start(){
		//初始化元胞
    	cell=Map.Create();
    	//获得细胞周围或细胞数
    	Map.getLivings(cell);
    	//网格初始化
    	g=jpanel.getGraphics();
    	//开始监听
    	button.addActionListener(this);
    	button2.addActionListener(this);
	}
	
	public static void main(String[] args) {
		GUI gui=new GUI();
		gui.start();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button)
			StartPrint(cell);
		else if(e.getSource()==button2){
			drawCell(cell);
		}
	}
}