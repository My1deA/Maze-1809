
import java.util.*;


public class conceal 
{
	int extent;
	void SetExtent(int n)
	{
		this.extent=n;
	}
	int up(int x1)
	{
		if(x1-extent>=0)
		{
			return x1-extent;
		}
		else
		{
			return 0;
		}
	}
	int down(int x2)
	{
		if(x2+extent<=24)
		{
			return x2+extent;
		}
		else
		{
			return 24;
		}
	}
	int left(int y1)
	{
		if(y1-extent>=0)
		{
			return y1-extent;
		}
		else
		{
			return 0;
		}
	}
	int right(int y2)
	{
		if(y2+extent<=24)
		{
			return y2+extent;
		}
		else
		{
			return 24;
		}
	}
	
}