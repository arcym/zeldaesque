package arcym;

import org.lwjgl.*;
import org.newdawn.slick.*;
import org.newdawn.slick.tiled.*;

public class Zeldaesque extends BasicGame
{
	private TiledMap room;
	private TiledMap room1;
	private TiledMap room2;
	
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
			room = room1 = new TiledMap("lvl/room1.tmx");
			room2 = new TiledMap("lvl/room2.tmx");
			
			link = new Hero(4 * room.getTileWidth(), 4 * room.getTileHeight()); 
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
	
	public void render(GameContainer container, Graphics g) throws SlickException
	{
		room.render(0, 0);
		link.render();
	}
	
	private boolean isWalkable(float x, float y)
	{
		int tx = ((int)x + (link.getWidth() / 2)) / room.getTileWidth();
		int ty = ((int)y + (link.getHeight() / 2)) / room.getTileHeight();
		
		if(tx < 0 || tx > room.getWidth()-1
		|| ty < 0 || ty > room.getHeight()-1)
		{
			return true;
		}
		
		int tid = room.getTileId(tx, ty, 0);
		return room.getTileProperty(tid, "blocked", "false").equals("false");
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