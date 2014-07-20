package arcym;

import org.lwjgl.*;
import org.newdawn.slick.*;
import org.newdawn.slick.tiled.*;

public class Zeldaesque extends BasicGame
{
	private TiledRoom room;
	private Hero link;
	
	private final int SCALE = 64;
	
	public Zeldaesque()
	{
		super("Zeldaesque");
	}
		
	
	public void init(GameContainer container) throws SlickException
	{
		try
		{
			room = new TiledRoom("lvl/room1.tmx");
			link = new Hero(4, 4, room);
		}
		catch (SlickException error)
		{
			System.out.println(error.getMessage());
		}
	}
	
	public void update(GameContainer container, int delta) throws SlickException
	{
		Input input = container.getInput();
		link.update(input, delta);
		
		/*if(room == room1 && y < 0 - (48/2))
		{
			room = room2;
			y = 7 * 64 - (48/2) - 2;
		}
		else if(room == room2 && y > 7 * 64 - (48/2) - 1)
		{
			room = room1;
			y = 0 - (48/2);
		}*/
	}
	
	public void render(GameContainer container, Graphics gfx) throws SlickException
	{
		room.render();
		link.render();
	}
	
	
	
	public static void main(String[] args)
	{
		try
		{
			container = new AppGameContainer(new Zeldaesque());
			container.setDisplayMode(11*64, 7*64, false);
			container.start();
		}
		catch(Exception error)
		{
			System.out.println(error.getMessage());
		}
	}
	
	public static AppGameContainer container;
}