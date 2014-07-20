package arcym;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class TiledRoom extends TiledMap
{
	public TiledRoom(String filepath) throws SlickException
	{
		 super(filepath);
	}
	
	public void render()
	{
		this.render(0, 0);
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
		
		int tid = this.getTileId(tx, ty, 0);
		return this.getTileProperty(tid, "blocked", "false").equals("false");
	}
}