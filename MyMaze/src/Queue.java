import javax.lang.model.element.QualifiedNameable;

public class Queue {
	int Push_xy=0;
	int Pop_x=0;
	int Pop_y=0;
	int Queue_x[]=new int[100];
	int Queue_y[]=new int[100];
	
	public Queue() {
		// TODO Auto-generated constructor stub
	}
	
	public int Pop_Queue_x() {
		Pop_x++;
		return Queue_x[Pop_x-1];
	}
	
	public int Pop_Queue_y() {
		Pop_y++;
		return Queue_y[Pop_y-1];
	}
	
	public void Push_Queue(int x,int y) {
		for(int i=0;i<100;i++) {
			if(Queue_x[i]==x&&Queue_y[i]==y) {
				return;
			}
		}
		Queue_x[Push_xy]=x;
		Queue_y[Push_xy]=y;
		Push_xy++;
	}
	
	public boolean isEmtry() {
		if(Push_xy==Pop_x)return true;
		else return false;
	}
	
	public void Clear_Queue() {
		for(int i=0;i<100;i++) {
			Queue_x[i]=0;
			Queue_y[i]=0;
		}
		Push_xy=0;
		Pop_x=0;
		Pop_y=0;
	}
	
	public void equal(Queue Q) {
		for(int i=0;i<100;i++) {
			Queue_x[i]=Q.Pop_Queue_x();
			Queue_y[i]=Q.Pop_Queue_y();
			if(Queue_x[i]!=0&&Queue_y[i]!=0) {
				Push_xy++;
			}
			if(Q.isEmtry())break;
			
		}
		Pop_x=0;
		Pop_y=0;
	}
	
}

























