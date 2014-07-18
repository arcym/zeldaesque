package arcym;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Room
{
	public TiledMap tiles;
	
	public Room(String filepath) throws SlickException
	{
		 tiles = new TiledMap(filepath);
	}
	
	public void render()
	{
		tiles.render(0, 0);
	}
	
	public int getWidth()
	{
		return tiles.getWidth();
	}
	
	public int getHeight()
	{
		return tiles.getHeight();
	}
	
	public int getTileWidth()
	{
		return tiles.getTileWidth();
	}
	
	public int getTileHeight()
	{
		return tiles.getTileHeight();
	}
	
	public boolean isWalkable(float x, float y)
	{
		int tx = (int)x / getTileWidth();
		int ty = (int)y / getTileHeight();
		
		if(tx < 0 || tx > getWidth() - 1
		|| ty < 0 || ty > getHeight() - 1)
		{
			return true;
		}
		
		int tid = tiles.getTileId(tx, ty, 0);
		return tiles.getTileProperty(tid, "blocked", "false").equals("false");
	}
}