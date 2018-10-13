import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

public class Pink {
	static public int x=2;
	static public int y=2;
	
	public Pink() {
		
	}
	
	public static void 	Up() {
		if(Map.Map1[x][y-1]!=4) {
			y--;
		}
	}
	
	public static void Down() {
		if(Map.Map1[x][y+1]!=4) {
			y++;
		}
	}
	
	public static void Left() {
		if(Map.Map1[x-1][y]!=4) {
			x--;
		}
	}
	public static void Right() {
		if(Map.Map1[x+1][y]!=4) {
			x++;
		}
	}
	
	
	
//	public static void 	Up() {
//		if(Map.Map1[y-1][x]!=4) {
//			y--;
//		}
//	}
//	
//	public static void Down() {
//		if(Map.Map1[y+1][x]!=4) {
//			y++;
//		}
//	}
//	
//	public static void Left() {
//		if(Map.Map1[y][x-1]!=4) {
//			x--;
//		}
//	}
//	public static void Right() {
//		if(Map.Map1[y][x+1]!=4) {
//			x++;
//		}
//	}
//	
	
	//ÉèÎª·ÛºìÉ«
//	public void paintComponent(Graphics g1) {
//		super.paintComponent(g1);
//		Graphics2D g=(Graphics2D) g1;
//		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
//		
//		g.setColor(Color.pink);
//		g.fillRoundRect(x*20, y*20, 20, 20, 10, 10);
//	}

}
