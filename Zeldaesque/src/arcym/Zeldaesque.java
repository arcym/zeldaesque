package arcym;

import org.lwjgl.*;
import org.newdawn.slick.*;
import org.newdawn.slick.tiled.*;

public class Zeldaesque extends BasicGame
{
	private TiledMap room1;
	private TiledMap room2;
	private TiledMap room;
	private Image img;
	
	private float x = 64 * 4;
	private float y = 64 * 4;
	private float speed = 0.1f;
	
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
			img = new Image("res/hero.png");
		}
		catch (SlickException error)
		{
			System.out.println(error.getMessage());
		}
	}
	
	public void update(GameContainer container, int delta) throws SlickException
	{
		Input input = container.getInput();
		
		if(input.isKeyDown(Input.KEY_UP))
		{
			if(isWalkable(x, y - speed * delta))
			{
				y -= speed * delta;
			}
		}
		else if(input.isKeyDown(Input.KEY_DOWN))
		{
			if(isWalkable(x, y + speed * delta))
			{
				y += speed * delta;
			}
		}
		
		if(input.isKeyDown(Input.KEY_LEFT))
		{
			if(isWalkable(x - speed * delta, y))
			{
				x -= speed * delta;
			}
		}
		else if(input.isKeyDown(Input.KEY_RIGHT))
		{
			if(isWalkable(x + speed * delta, y))
			{
				x += speed * delta;
			}
		}
		
		if(room == room1 && y < 0 - (48/2))
		{
			room = room2;
			y = 7 * 64 - (48/2) - 2;
		}
		else if(room == room2 && y > 7 * 64 - (48/2) - 1)
		{
			room = room1;
			y = 0 - (48/2);
		}
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException
	{
		room.render(0, 0);
		img.draw((int)x, (int)y);
	}
	
	private boolean isWalkable(float x, float y)
	{
		int tx = ((int)x + (48/2)) / 64;
		int ty = ((int)y + (48/2)) / 64;
		
		if(tx < 0 || tx > 11-1
		|| ty < 0 || ty > 7-1)
		{
			return false;
		}
		
		int tid = room.getTileId(tx, ty, 0);
		
		return room.getTileProperty(tid, "blocked", "false").equals("false");
	}
	
	public static AppGameContainer container;
	
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
}