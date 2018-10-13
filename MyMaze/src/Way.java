
public class Way {
//	static int m[][] = {
//			{4 ,4, 4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 },//0
//			{4 ,1, 4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 },//1
//			{4 ,1, 4 ,4 ,4 ,4 ,4 ,4 ,1 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 },//2
//			{4 ,1, 4 ,4 ,4 ,4 ,4 ,4 ,1 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 },//3
//			{4 ,1, 4 ,1 ,1 ,1 ,1 ,1 ,1 ,4 ,4 ,4 ,4 ,1 ,4 ,4 ,4 ,4 },//4
//			{4 ,1, 4 ,1 ,4 ,4 ,4 ,1 ,4 ,4 ,4 ,4 ,4 ,1 ,4 ,4 ,4 ,4 },//5
//			{4 ,1, 1 ,1 ,4 ,4 ,4 ,1 ,4 ,4 ,4 ,4 ,4 ,1 ,4 ,4 ,4 ,4 },//6
//			{4 ,4, 4 ,4 ,4 ,4 ,4 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,4 },//7
//			{4 ,4, 4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 ,4 },//8
////			 0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17
//	};
	
	public static int m[][]=new int[25][25];
	
	public int di(int x,int y,int m[][]) {
		if(m[x][y+1]==1) //右
		{
			return 1;
		}
		else if(m[x+1][y]==1)//下
		{
			return 2;
		}
		else if(m[x][y-1]==1)//左
		{
			return 3;
		}
		else if(m[x-1][y]==1)//上
		{
			return 4;
		}
		return 5;
	}
	 
	public Way(){
		
		for(int i=0;i<25;i++) {
			for(int j=0;j<25;j++) {
				m[i][j]=Map.Map1[i][j];
			}
		}
		m[2][2]=1;
		m[22][23]=1;
		
		for(int i=0;i<25;i++) {
			for(int j=0;j<25;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println("");
		}
		
		Stack S = new Stack();
		
		Location l = new Location();
		l.x = 2;
		l.y = 2;
		S.Push(l);
		//need debug
		do 
		{
			System.out.print("lx = "+l.x+" "+"ly = "+l.y);
			if(di(l.x,l.y,m)==1)//右有路
			{
				System.out.println("     di 1");
				S.Push(l);
				m[l.x][l.y] = 7;
				l.y++;
			}
			else if(di(l.x,l.y,m)==2)//下有路
			{
				System.out.println("     di 2");
				S.Push(l);
				m[l.x][l.y] = 7;
				l.x++;
			}
			else if(di(l.x,l.y,m)==3)//左有路
			{
				System.out.println("     di 3");
				S.Push(l);
				m[l.x][l.y] = 7;
				l.y--;
			}
			else if(di(l.x,l.y,m)==4)//上有路
			{
				System.out.println("     di 4");
				S.Push(l);
				m[l.x][l.y] = 7;
				l.x--;
			}
			else if(di(l.x,l.y,m)==5)//是墙或者是走过的路
			{
				System.out.println("     di 5");
				m[l.x][l.y] = 9;
				S.printS();
				S.Pop();
				l.x = S.loc[S.top].x;
				l.y = S.loc[S.top].y;
				System.out.println("change lx="+l.x+" "+"ly="+l.y);
			}
		}while(l.x!=22||l.y!=23);
		
		for(int i = 0;i<25;i++)
		{
			for(int j = 0;j<25;j++)
			{
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
		//bug
		for(int i=0;i<25;i++) {
			for(int j=0;j<25;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println("");
		}
		 
	}
	
	
	
}

class Stack{
	public Location[] loc = new Location[1000];
	int base;
	int top;
	Stack(){
		for(int i = 0;i<1000;i++) {
			loc[i] = new Location();
		}
		base = 0;
		top = 0;
	}
	public void Push(Location l) {
		loc[top] = new Location();
		loc[top].x = l.x;
		loc[top].y = l.y;
		top++;
		System.out.println("top="+top);
	}
	public void Pop() {
		if(this.top!=this.base) {
			this.top--;
		}else {
			printS();
		}
	}
	public void printS() {
		for(int i = this.top-1;i>=0;i--) {
			System.out.println(i+"["+this.loc[i].x+","+this.loc[i].y+"]");
		}
	}
}

class Location{
	public int x,y;
}



