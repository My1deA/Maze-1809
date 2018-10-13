
public class Answer {
	private Queue Queue_Now=new Queue();
	private Queue Queue_Temp=new Queue();
	public static int Map1[][]=new int [25][25];
	private int hadFoudPath = 0;
	
	public Answer() {
		for(int i=0;i<25;i++) {
			for(int j=0;j<25;j++) {
				Map1[i][j]=Map.Map1[i][j];
			}
		}
	}
	

	
	public void findAllPath(int x,int y) {
		int End=0;
		
		int count=7;
		
		Queue_Now.Push_Queue(2, 2);
		
		while(!Queue_Now.isEmtry()) {
			
			while(!Queue_Now.isEmtry()) {
				
				x=Queue_Now.Pop_Queue_x();
				y=Queue_Now.Pop_Queue_y();
				
				if(x<24&&y<24&&x>0&&y>0) {
					Map1[x][y]=count;
					
					if(Map1[x][y+1]==1||Map1[x][y+1]==3) {
						Queue_Temp.Push_Queue(x, y+1);
					}
					if(Map1[x][y-1]==1||Map1[x][y-1]==3) {
						Queue_Temp.Push_Queue(x, y-1);
					}
					if(Map1[x+1][y]==1||Map1[x+1][y]==3) {
						Queue_Temp.Push_Queue(x+1, y);
					}
					if(Map1[x-1][y]==1||Map1[x-1][y]==3) {
						Queue_Temp.Push_Queue(x-1, y);
					}
					if(x==Map.xEnd&&y==Map.yEnd) {
						End=count;
					}
				}
			}
			count++;
			Queue_Now.Clear_Queue();
			Queue_Now.equal(Queue_Temp);
			Queue_Temp.Clear_Queue();
		}
		x=Map.xEnd;
		y=Map.yEnd;
		
		Queue_Now.Push_Queue(x, y);
		while(!Queue_Now.isEmtry()) {
			End--;
			while(!Queue_Now.isEmtry()) {
				x=Queue_Now.Pop_Queue_x();
				y=Queue_Now.Pop_Queue_y();
				
				if(x<24&&x>0&&y>0&&y<24) {
					if(Map1[x][y+1]==End) {
						Queue_Temp.Push_Queue(x, y+1);
					}
					if(Map1[x][y-1]==End) {
						Queue_Temp.Push_Queue(x, y-1);
					}
					if(Map1[x+1][y]==End) {
						Queue_Temp.Push_Queue(x+1, y);
					}
					if(Map1[x-1][y]==End) {
						Queue_Temp.Push_Queue(x-1, y);
					}
					Map1[x][y]=5;
				}
			}
			Queue_Now.Clear_Queue();
			Queue_Now.equal(Queue_Temp);
			Queue_Temp.Clear_Queue();
		}	
//		for(int i=0;i<25;i++) {
//			for(int j=0;j<25;j++) {
//				System.out.print(Map1[i][j]+" ");
//			}
//			System.out.println("");
//		}
	}

	
	
	public void start() {
		findPath(Map.xStart, Map.yStart);
	}
	
	public void findPath(int x,int y) {
		int count =7;
//		int tx,ty;
		Queue_Now.Push_Queue(2, 2);
		while(!(x==22&&y==23)) {	
			while(!(x==22&&y==23)) {
				x=Queue_Now.Pop_Queue_x();
				y=Queue_Now.Pop_Queue_y();
				if(x>0&&y>0&&x<24&&y<24){
					this.Map1[x][y]=count;

					//right
					if(Map1[x][y+1]==1||Map1[x][y+1]==3) {
						Queue_Temp.Push_Queue(x, y+1);
					}
					//down
					if(Map1[x+1][y]==1||Map1[x+1][y]==3) {
						Queue_Temp.Push_Queue(x+1, y);
					}
					//left
					if(Map1[x][y-1]==1||Map1[x][y-1]==3) {
						Queue_Temp.Push_Queue(x, y-1);
					}
					//up
					if(Map1[x-1][y]==1||Map1[x-1][y]==3) {
						Queue_Temp.Push_Queue(x-1, y);
					}
					
					if(Queue_Now.isEmtry()) {
						break;
					}
				}
			}
			count++;
			Queue_Now.Clear_Queue();
			Queue_Now.equal(Queue_Temp);
			Queue_Temp.Clear_Queue();
			
		}
		
		while(!(x==2&&y==2)) {
			count--;
			this.Map1[x][y]=5;
			if(Map1[x][y-1]==count) {//left
				y--;
			}else if(Map1[x-1][y]==count) {//up
				x--;
			}else if(Map1[x][y+1]==count) {//right
				y++;
			}else if(Map1[x+1][y]==count) {//down
				x++;
			}
			
		}
		
	}
}

























