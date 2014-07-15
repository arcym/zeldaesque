package arcym;

import org.lwjgl.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Zeldaesque extends StateBasedGame
{
	public static AppGameContainer container;
	
	public Zeldaesque()
	{
		super("Legend of Zelder");
	}
	
	public static void main(String[] args)
	{
		try
		{
			container = new AppGameContainer(new Zeldaesque());
			container.setDisplayMode(640, 480, false);
			container.start();
		}
		catch(Exception error)
		{
			System.out.println(error.getMessage());
		}
	}
	
	public void initStatesList(GameContainer arg0) throws SlickException
	{
		//?!
	}
}