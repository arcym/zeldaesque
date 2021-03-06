package arcym;

import org.lwjgl.*;
import org.newdawn.slick.*;
import org.newdawn.slick.tiled.*;

public class Dungen extends BasicGame
{
	private Dungeon dungeon;
	private Hero link;
	
	private final int SCALE = 64;
	
	public Dungen()
	{
		super("Zeldaesque");
	}
		
	
	public void init(GameContainer container) throws SlickException
	{
		try
		{
			dungeon = new Dungeon();
			link = new Hero(6, 4, dungeon);
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
	}
	
	public void render(GameContainer container, Graphics gfx) throws SlickException
	{
		dungeon.render();
		link.render();
	}
	
	
	
	public static void main(String[] args)
	{
		try
		{
			container = new AppGameContainer(new Dungen());
			container.setDisplayMode(11*64, 9*64, false);
			container.start();
		}
		catch(Exception error)
		{
			System.out.println(error.getMessage());
		}
	}
	
	public static AppGameContainer container;
}