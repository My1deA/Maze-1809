public class Map {
	public static int [][] Map1=new int[25][25];
	public static int xStart;
	public static int yStart;
	public static int xEnd;
	public static int yEnd;
	
	private void Cre_map(int x,int y) {
		int direction[] = { 0, 0, 0, 0 };
		Map1[x][y] = 1;
		do {
			if(x<=1||y<=1||x>=24||y>=23) {
				return;
			}
			direction[0] = 0;
			direction[1] = 0;
			direction[2] = 0;
			direction[3] = 0;
			int count=0;
			if(Map1[x][y+2]==0) {//右
				direction[count]=1;
				count++;
			}
			if(Map1[x][y-2]==0) {//左
				direction[count]=2;
				count++;
			}
			if(Map1[x+2][y]==0) {//下
				direction[count]=3;
				count++;
			}
			if(Map1[x-2][y]==0) {//上
				direction[count]=4;
				count++;
			}
			
			if(direction[0]==0&&direction[1]==0&&direction[2]==0&&direction[3]==0) {
				return;
			}
			int temp=(int)(Math.random()*count);
//			System.out.println("temp");
			switch(direction[temp]){
			case 2://上
				Map1[x][y-1]=1;
				Cre_map(x,y-2);
				break;
			case 1://下
				Map1[x][y+1]=1;
				Cre_map(x, y+2);
				break;
			case 4://左
				Map1[x-1][y]=1;
				Cre_map(x-2,y);
				break;
			case 3://右
				Map1[x+1][y]=1;
				Cre_map(x+2,y);
				break;
			}		
		}while(Map1[x][y+2]!=0||Map1[x][y-2]!=0||Map1[x+2][y]!=0||Map1[x-2][y]!=0);
	}
	
	public  Map() {
		xStart=2;
	 	yStart=2;
 		xEnd=22;
		yEnd=23;
		Cre_map(xStart, yStart);
		for(int i=0;i<25;i++) {
			for(int j=0;j<25;j++) {
				if(Map1[i][j]!=1&&Map1[i][j]!=2&&Map1[i][j]!=3) {
					Map1[i][j]=4;
				}
			}
		}
		Map1[xStart][yStart]=2;
		Map1[xEnd][yEnd]=3;
		for(int i=0;i<25;i++) {
			Map1[i][0]=4;
			Map1[i][24]=4;
		}
		for(int i=0;i<25;i++) {
			Map1[0][i]=4;
			Map1[24][i]=4;
		}
		
		
	}
}














