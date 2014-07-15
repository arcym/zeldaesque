package arcym;

import org.lwjgl.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Zeldaesque extends BasicGame
{
	public static AppGameContainer container;
	
	public Zeldaesque()
	{
		super("Zeldaesque");
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
	
	public void render(GameContainer arg0, Graphics arg1) throws SlickException
	{
		//?!
	}
	
	public void init(GameContainer arg0) throws SlickException
	{
		//?!
	}
	
	public void update(GameContainer arg0, int arg1) throws SlickException
	{
		//?!	
	}
}