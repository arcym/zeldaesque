package arcym;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Hero
{
	private float x;
	private float y;
	private Image img;
	private float speed = 0.1f;
	private Dungeon dungeon;
	
	public Hero(float x, float y, Dungeon dungeon) throws SlickException
	{
		this.x = (x + 0.5f) * dungeon.room.getTileWidth();
		this.y = (y + 0.5f) * dungeon.room.getTileHeight();
		
		this.dungeon = dungeon;
		
		this.img = new Image("res/hero.png");
	}
	
	private int i = 0;
	
	public void update(Input input, int delta)
	{
		if(input.isKeyDown(Input.KEY_UP))
		{
			if(dungeon.room.isWalkable(x, y - speed * delta))
			{
				y -= speed * delta;
				
				if(y < 0)
				{
					y = dungeon.room.getPixelHeight();
				}
			}
		}
		else if(input.isKeyDown(Input.KEY_DOWN))
		{
			if(dungeon.room.isWalkable(x, y + speed * delta))
			{
				y += speed * delta;
				
				if(y > dungeon.room.getPixelHeight())
				{
					y = 0;
				}
			}
		}
		
		if(input.isKeyDown(Input.KEY_LEFT))
		{
			if(dungeon.room.isWalkable(x - speed * delta, y))
			{
				x -= speed * delta;
				
				if(x < 0)
				{
					x = dungeon.room.getPixelWidth();
				}
			}
		}
		else if(input.isKeyDown(Input.KEY_RIGHT))
		{
			if(dungeon.room.isWalkable(x + speed * delta, y))
			{
				x += speed * delta;
				
				if(x > dungeon.room.getPixelWidth())
				{
					x = 0;
				}
			}
		}
	}
	
	public void render()
	{
		img.draw((int)x - (getWidth() / 2), (int)y - (getHeight() / 2));
	}
	
	public int getWidth()
	{
		return img.getWidth();
	}
	
	public int getHeight()
	{
		return img.getHeight();
	}
}