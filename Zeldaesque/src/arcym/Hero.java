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
	private TiledRoom room;
	
	public Hero(float x, float y, TiledRoom room) throws SlickException
	{
		this.room = room;
		
		this.x = (x + 0.5f) * room.getTileWidth();
		this.y = (y + 0.5f) * room.getTileHeight();
		
		this.img = new Image("res/hero.png");
	}
	
	public void update(Input input, int delta)
	{
		if(input.isKeyDown(Input.KEY_UP))
		{
			if(room.isWalkable(x, y - speed * delta))
			{
				y -= speed * delta;
			}
		}
		else if(input.isKeyDown(Input.KEY_DOWN))
		{
			if(room.isWalkable(x, y + speed * delta))
			{
				y += speed * delta;
			}
		}
		
		if(input.isKeyDown(Input.KEY_LEFT))
		{
			if(room.isWalkable(x - speed * delta, y))
			{
				x -= speed * delta;
			}
		}
		else if(input.isKeyDown(Input.KEY_RIGHT))
		{
			if(room.isWalkable(x + speed * delta, y))
			{
				x += speed * delta;
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