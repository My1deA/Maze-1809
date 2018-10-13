import java.awt.*;
import javax.swing.*;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import java.awt.event.*;
import java.awt.font.GraphicAttribute;
import java.io.*;
import java.util.*;

public class Maze extends JComponent {
	private static final long serialVersionUID = 3794762291171148906L;
	private Thread Run;
	Map M;
	Pink P;
	Answer Ans;
	MyWay Myway;
	Way Way1;
//	int Map1[][];
	private static boolean flag=false;
	private static boolean flag2=false;
	private static boolean flag3=false;
	private JLabel label1=new JLabel("����ʱ�䣺");
	private JLabel label2=new JLabel("˵����");
	private JPanel p=new JPanel();
	private JTextArea area=new JTextArea("����Ϸ��ԭ�����Թ���Ϸ�Ĳ��԰汾���϶����������bug����ָ�� "+""
			+ "��Ϸ��ʼʱPink����ҿ���Ŀ�꣬ͨ��W A S D ������ �� �� �ҵĲ��� ��M ������ʾ��Ŀ�ĵ�Green��·��"+""
					+ "��K Ҳ������ʾ��Ŀ�ĵ�Green��·��");
	private JLabel Time=new JLabel("");
	private Font f=new Font("΢���ź�", Font.PLAIN, 15);
	private Font f2=new Font("΢���ź�", Font.PLAIN, 13);
	
	private int hour=0;
	private int min=0;
	private int sec=0;
	private boolean pause=false;
	private boolean isrun=true;
	
	public Maze() {
		M=new Map();
	    P=new Pink();
		Ans=new Answer();
		
		
		add(label1);
		label1.setBounds(510,10,80,20);
		label1.setFont(f);
		
		add(Time);
		Time.setBounds(510,35,80,20);
		Time.setFont(f);
		
		add(p);
		p.setBounds(505,65,90,1);
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		
		add(label2);
		label2.setBounds(510,75,80,20);
		label2.setFont(f);
		
		add(area);
		area.setBounds(510,100,100,350);
		area.setFont(f2);
		area.setLineWrap(true);
		area.setOpaque(false);
		//�����ǹ�����
		

		
		addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_W) {
					Pink.Up();
//					Pink.y--;
//					System.out.println(Pink.x+" "+Pink.y);
					repaint();
					WinnerorGameover();
				}
				if(e.getKeyCode()==KeyEvent.VK_S) {
//					System.out.println("DOWN");
					Pink.Down();
//					Pink.y++;
//					System.out.println(Pink.x+" "+Pink.y);
					repaint();
					WinnerorGameover();
				}
				if(e.getKeyCode()==KeyEvent.VK_A) {
					Pink.Left();
//					Pink.x--;
//					System.out.println(Pink.x+" "+Pink.y);
					repaint();
					WinnerorGameover();
				}
				if(e.getKeyCode()==KeyEvent.VK_D) {
					Pink.Right();
//					Pink.x++;
//					System.out.println(Pink.x+" "+Pink.y);
					repaint();
					WinnerorGameover();
				}
				if(e.getKeyCode()==KeyEvent.VK_M) {
					flag=true;
					Ans.findAllPath(Map.xStart, Map.yStart);
					for(int i=0;i<25;i++) {
						for(int j=0;j<25;j++) {
							if(Ans.Map1[i][j]==6) {
								Ans.Map1[i][j]=1;
							}
						}
					}
					Map.Map1[2][2]=2;
					Map.Map1[22][23]=3;
					repaint();
				}
				
				if(e.getKeyCode()==KeyEvent.VK_K) {
					flag2=true;
//					Way1=new Way();
					Myway=new MyWay();
					Map.Map1[2][2]=2;
					Map.Map1[22][23]=3;
					repaint();
					
				}
				if(e.getKeyCode()==KeyEvent.VK_O) {
					flag3=true;
					Way1=new Way();
//					Myway=new MyWay();
					Map.Map1[2][2]=2;
					Map.Map1[22][23]=3;
					repaint();
					
				}
			}
					
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}		
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

		});
		new Timer();
		setFocusable(true);
		
	}


	public void paintComponent(Graphics g1) {
		//С����С��
		super.paintComponent(g1);
		Graphics2D g=(Graphics2D) g1;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
		
		//·��
		if(flag) {
			g.setColor(Color.CYAN);
			for(int i=0;i<25;i++) {
				for(int j=0;j<25;j++) {
					if(Ans.Map1[i][j]==5) {
						g.fillRoundRect(i*20, j*20, 20, 20, 2, 2);
					}
				}
			}
			flag=false;
		}
		
		if(flag2) {
			g.setColor(Color.yellow);
			for(int i=0;i<25;i++) {
				for(int j=0;j<25;j++) {
					if(Myway.Map1[i][j]==5) {
						g.fillRoundRect(i*20, j*20, 20, 20, 2, 2);
					}
				}
			}
			flag2=false;
		}
		
		if(flag3) {
			g.setColor(Color.yellow);
			for(int i=0;i<25;i++) {
				for(int j=0;j<25;j++) {
					if(Way.m[i][j]==7) {
						g.fillRoundRect(i*20, j*20, 20, 20, 2, 2);
					}
				}
			}
			flag3=false;
		}
		
		//С��
		g.setColor(Color.green);
		g.fillRoundRect(Map.xEnd*20, Map.yEnd*20, 20, 20, 10, 10);
		
		//�ϰ�
		conceal E =new conceal();
		g.setColor(Color.black);
		//System.out.println(Pink.x+" "+Pink.y);
		E.SetExtent(4);
		for(int i=0;i<=24;i++)
		{
			for(int j=0;j<=24;j++)
			{
				if(i>=E.up(Pink.x)&&i<=E.down(Pink.x)&&j>=E.left(Pink.y)&&j<=E.right(Pink.y))
				{
					continue;
				}
				else
				{
				g.fillRoundRect(i*20, j*20, 20, 20, 2, 2);
				}
			}
		}

		
		//С��
		g.setColor(Color.pink);
		g.fillRoundRect(Pink.x*20, Pink.y*20, 20, 20, 10, 10);

		
		//��Ϸ�����ǽ
		g.setColor(Color.black);
		
		for(int i=0;i<25;i++) {
			for(int j=0;j<25;j++) {
				if(Map.Map1[i][j]==4) {
					g.fillRoundRect(i*20, j*20, 20, 20, 2, 2);
				}
			}
		}
		
		
		//·��
		if(flag) {
			g.setColor(Color.yellow);
			for(int i=0;i<25;i++) {
				for(int j=0;j<25;j++) {
					if(Ans.Map1[i][j]==5) {
						
						g.fillRoundRect(i*20, j*20, 20, 20, 2, 2);
					}
				}
			}
		}
		
		
		//JFrame����ļ��
		for(int i=1;i<25;i++) {
			g.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL));
			g.setColor(Color.BLACK);
			g.drawLine(i*20,0,20*i,500);
			g.drawLine(0,i*20,500,i*20);
		}
		
		
		
		//4��ǽ
		g.setPaint(new GradientPaint(115, 135, Color.ORANGE, 230,135,Color.MAGENTA,true));
		g.setStroke(new BasicStroke(4,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL));
		g.setBackground(Color.BLACK);
		g.drawRect(0, 0, 500, 500);
		
		
		
		
	}
	
	
	public void WinnerorGameover() {
		if(Pink.x==Map.xEnd&&Pink.y==Map.yEnd) {
			int result=JOptionPane.showConfirmDialog(null,"Winner Winner  Chicken dinner");
			if(result==JOptionPane.YES_NO_OPTION) {
				P=new Pink();
				M=new Map();
				Ans=new Answer();
				hour=0;
				min=2;
				sec=0;
				repaint();
			}
		}
	}
	
	public void Thread() {
		//long millis=300;
		Run=new Thread() {
			public void Run() {
				
			}
		};
		
		
		
	}
	
	
	
	
	class Timer extends Thread{
		public Timer() {
			this.start();
		}
		public void run() {
			while(true) {
				if(isrun) {
					sec++;
					if(sec==60) {
						min++;
						sec=0;
					}
					if(min==60) {
						hour++;
						min=0;
					}
					showTime();
					try {
						Thread.sleep(1000);
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		}
		public void showTime() {
			String time1="";
			if(hour>=10) {
				time1+=""+hour+":";
			}else {
				time1+="0"+hour+":";
			}
			
			if(min>=10) {
				time1+=""+min+":";
			}else {
				time1+="0"+min+":";
			}
			
			if(sec>=10) {
				time1+=""+sec;
			}else {
				time1+="0"+sec;
			}
			
			
			Time.setText(time1);
		}
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		Maze maze=new Maze();
		JFrame game=new JFrame("Maze.test");
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setSize(610, 550);
		game.setResizable(false);
		game.setLocationRelativeTo(null);
		game.add(maze);
		game.setVisible(true);
		
		
	}

}



















