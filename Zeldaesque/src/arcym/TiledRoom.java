package arcym;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class TiledRoom extends TiledMap
{
	public TiledRoom westernNeighbor;
	public TiledRoom easternNeighbor;
	public TiledRoom southernNeighbor;
	public TiledRoom northernNeighbor;
	
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
	
	public void setNeighbor(Direction direction, TiledRoom room)
	{
		if(direction == Direction.NORTH)
		{
			setNorthernNeighbor(room);
		}
		else if(direction == Direction.SOUTH)
		{
			setSouthernNeighbor(room);
		}
		else if(direction == Direction.EAST)
		{
			setEasternNeighbor(room);
		}
		else if(direction == Direction.WEST)
		{
			setWesternNeighbor(room);
		}
	}
	
	public void setNorthernNeighbor(TiledRoom room)
	{
		this.northernNeighbor = room;
		this.setTileId(11/2, 0, 0, 1);
		
		room.southernNeighbor = this;
		room.setTileId(11/2, 9-1, 0, 1);
	}
	
	public void setSouthernNeighbor(TiledRoom room)
	{
		this.southernNeighbor = room;
		this.setTileId(11/2, 9-1, 0, 1);
		
		room.northernNeighbor = this;
		room.setTileId(11/2, 0, 0, 1);
	}
	
	public void setEasternNeighbor(TiledRoom room)
	{
		this.easternNeighbor = room;
		this.setTileId(11-1, 9/2, 0, 1);
		
		room.westernNeighbor = this;
		room.setTileId(0, 9/2, 0, 1);
	}
	
	public void setWesternNeighbor(TiledRoom room)
	{
		this.westernNeighbor = room;
		this.setTileId(0, 9/2, 0, 1);
		
		room.easternNeighbor = this;
		room.setTileId(11-1, 9/2, 0, 1);
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