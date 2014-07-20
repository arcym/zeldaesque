package arcym;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class TiledRoom extends TiledMap
{
	public TiledRoom west;
	public TiledRoom east;
	public TiledRoom south;
	public TiledRoom north;
	
	public TiledRoom(String filepath) throws SlickException
	{
		 super(filepath);
	}
	
	public int getPixelWidth()
	{
		return getWidth() * getTileWidth();
	}
	
	public int getPixelHeight()
	{
		return getHeight() * getTileHeight();
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
		
		int tid = getTileId(tx, ty, 0);
		return getTileProperty(tid, "blocked", "false").equals("false");
	}
}