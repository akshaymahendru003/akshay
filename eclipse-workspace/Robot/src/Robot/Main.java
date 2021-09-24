package Robot;

import java.util.Scanner;

public class Main {
	
	Scanner obj;
	String a;
	int x=0,y=0;
	String direction="NULL";
	
	public void getPlace(String a)
	{
	String d[];
	int b=a.indexOf(" ");
	String c=a.substring(b+1);
	d=c.split(",");
	x=Integer.parseInt(d[0]);
	y=Integer.parseInt(d[1]);
		
	if(direction.equals("NULL"))
	{
		direction=d[2];
	}
				
	}
	
	public void move()
	{
		if(direction.equals("NORTH"))
		{ 
			if(y<5)
			y=y+1;
		}
		else if(direction.equals("SOUTH"))
		{   
			if(y>0)
			y=y-1;
		}
		else if(direction.equals("EAST"))
		{
			if(x<5)
			x=x+1;
		}
		else if(direction.equals("WEST"))
		{
			if(x>0)
			x=x-1;
		}
	}
	
	public void left()
	{
		
		if(direction.equals("NORTH"))
		{
			direction="WEST";
		}
		else if(direction.equals("SOUTH"))
		{   
			direction="EAST";
		}
		else if(direction.equals("EAST"))
		{
			direction="NORTH";
		}
		else if(direction.equals("WEST"))
		{
			direction="SOUTH";
		}
	}
	
	public void right()
	{
		if(direction.equals("NORTH"))
		{
			direction="EAST";
		}
		else if(direction.equals("SOUTH"))
		{   
			direction="WEST";
		}
		else if(direction.equals("EAST"))
		{
			direction="SOUTH";
		}
		else if(direction.equals("WEST"))
		{
			direction="NORTH";
		}
		
	}
	public void report()
	{
		
		System.out.println("OUTPUT: "+x+","+y+","+direction);
	}
	

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int end=0;
		Scanner obj1;
		obj1=new Scanner(System.in);
		Main obj2=new Main();
		
		while(end==0)
		{
			String c;
			c=obj1.nextLine();
			if(c.matches("PLACE [0-5],[0-5],NORTH")|c.matches("PLACE [0-5],[0-5],SOUTH")|c.matches("PLACE [0-5],[0-5],WEST")|c.matches("PLACE [0-5],[0-5],EAST"))
			{
				
			obj2.getPlace(c);
			while(end==0)
			{
			String a;
			a=obj1.nextLine();
			
			if(a.equals("REPORT"))
			{
				end=1;
				obj2.report();
				
			}
			else if(a.matches("PLACE [0-5],[0-5]"))
			{
				obj2.getPlace(a);
			}
			else if(a.equals("MOVE"))
			{
				obj2.move();
			}
			else if(a.equals("LEFT"))
			{
				obj2.left();
			}
			else if(a.equals("RIGHT"))
			{
				obj2.right();
			}
			else
			{
				System.out.println("Check the syntax of command!");
			}
			
			}
			}
			else
			{
			System.out.println("First command should be place or syntax of place is wrong or movement is causing destruction");
			}
			
		}
		
		
	}


}
