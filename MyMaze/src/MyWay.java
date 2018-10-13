/**
 * 
 * @author LTS
 *
 */
public class MyWay {
	public static int top=0;
	public static int base=0;
	public static Location2 locate[]=new Location2 [500];
	
	public static int Map1[][]=new int[25][25];

	public static void Init() {	
		for(int i=0;i<25;i++) {
			for(int j=0;j<25;j++) {
				Map1[i][j]=Map.Map1[i][j];
			}
		}
		Map1[Map.xStart][Map.yStart]=1;
		Map1[Map.xEnd][Map.yEnd]=1;
		
		for(int i=0;i<500;i++) {
			locate[i]=new Location2();
		}
	}
	
	public static void Clean() {
		top=0;
		base=0;
	}
	
	public static boolean isEmtry() {
		if(base==top)return true;
		else return false;
	}
	
	public static void Push(int x,int y) {
		if(top<500) {
			locate[top].x=x;
			locate[top].y=y;
			top++;
		}
		
	}
	
	public static void Pop() {
		top--;
		locate[top].x=0;
		locate[top].y=0;
	}
	
	public static Location2 ReturnTop() {
		if(top>=1) {
			return locate[top-1];
		}else return locate[0];	
	}
	
	public static void findWay() {
		int x=2;
		int y=2;
		do {
			if(Map1[x][y]==1) {
				Push(x, y);
				Map1[x][y]=5;//已经放入过
			    if(x==22&&y==23) {
				    break;
			    }else {
				    y++;
			    }
		    }else {
		    	Location2 t=ReturnTop();
		    	x=t.x;
		    	y=t.y;
		    	if(!isEmtry()) {
		    		if(Map1[x+1][y]==1) {
		    			x++;
		    		}else if(Map1[x][y-1]==1) {
		    			y--;
		    		}else if(Map1[x-1][y]==1) {
		    			x--;
		    		}else {

	    		    	Map1[x][y]=7;//没用了
	    		    	Pop();
	    		    	t=ReturnTop();
	    		    	x=t.x;
	    		    	y=t.y;
//	    		    	
		    			while(!isEmtry()&&!(Map1[x+1][y]==1||Map1[x][y-1]==1||Map1[x-1][y]==1||Map1[x][y+1]==1)) {

		    		    	Map1[x][y]=7;//没用了
		    		    	Pop();
		    		    	
		    		    	t=ReturnTop();
		    		    	x=t.x;
		    		    	y=t.y;
		    			}
		    			y++;
			    	}

		    	}
		    	
		    }

		}while(!isEmtry());
	}
	
	public static void Change() {
		for(int i=0;i<25;i++) {
			for(int j=0;j<25;j++) {
				System.out.print(Map1[j][i]+" ");
			}
			System.out.println("");
		}
	}
	
	
	
	public MyWay() {
		
		Init();
		Change();
		findWay();
		System.out.println("");
		System.out.println("");
		System.out.println("");
		Change();
		Clean();
	}

}

class  Location2{
	int x;
	int y;
}
