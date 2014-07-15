package arcym;

import org.lwjgl.*;
import org.newdawn.slick.*;
import org.newdawn.slick.tiled.*;

public class Zeldaesque extends BasicGame
{
	private TiledMap room;
	private Image img;
	
	private float x = 64 * 4;
	private float y = 64 * 4;
	
	public Zeldaesque()
	{
		super("Zeldaesque");
	}
		
	
	public void init(GameContainer container) throws SlickException
	{
		try
		{
			room = new TiledMap("lvl/room.tmx");
			img = new Image("res/hero.png");
		}
		catch (SlickException error)
		{
			System.out.println(error.getMessage());
		}
	}
	
	public void update(GameContainer container, int delta) throws SlickException
	{
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException
	{
		room.render(0, 0);
		img.draw((int)x, (int)y);
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