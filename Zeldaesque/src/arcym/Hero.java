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
	
	public Hero(float x, float y) throws SlickException
	{
		this.x = x;
		this.y = y;
		
		this.img = new Image("res/hero.png");
	}
	
	public void update(Input input, int delta)
	{
		if(input.isKeyDown(Input.KEY_UP))
		{
			//if(isWalkable(x, y - speed * delta))
			{
				y -= speed * delta;
			}
		}
		else if(input.isKeyDown(Input.KEY_DOWN))
		{
			//if(isWalkable(x, y + speed * delta))
			{
				y += speed * delta;
			}
		}
		
		if(input.isKeyDown(Input.KEY_LEFT))
		{
			//if(isWalkable(x - speed * delta, y))
			{
				x -= speed * delta;
			}
		}
		else if(input.isKeyDown(Input.KEY_RIGHT))
		{
			//if(isWalkable(x + speed * delta, y))
			{
				x += speed * delta;
			}
		}
	}
	
	public void render()
	{
		img.draw((int)x, (int)y);
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