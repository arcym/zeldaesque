package arcym;

import java.io.File;
import java.util.Random;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class TiledRoom extends TiledMap
{
	public TiledRoom westernNeighbor;
	public TiledRoom easternNeighbor;
	public TiledRoom southernNeighbor;
	public TiledRoom northernNeighbor;
	
	public TiledRoom() throws SlickException
	{
		super(getRandomRoomLayout());
	}
	
	public TiledRoom(String roomlayout) throws SlickException
	{
		super(roomlayout);
	}
	
	public int getPixelWidth()
	{
		return getWidth() * getTileWidth();
	}
	
	public int getPixelHeight()
	{
		return getHeight() * getTileHeight();
	}
	
	public void connectRoom(Direction direction, TiledRoom room)
	{
		if(direction == Direction.NORTH)
		{
			connectNorthernRoom(room);
		}
		else if(direction == Direction.SOUTH)
		{
			connectSouthernRoom(room);
		}
		else if(direction == Direction.EAST)
		{
			connectEasternRoom(room);
		}
		else if(direction == Direction.WEST)
		{
			connectWesternRoom(room);
		}
	}
	
	public void connectNorthernRoom(TiledRoom that)
	{
		this.setNorthernRoom(that);
		that.setSouthernRoom(this);
	}
	
	public void connectSouthernRoom(TiledRoom that)
	{
		this.setSouthernRoom(that);
		that.setNorthernRoom(this);
	}
	
	public void connectEasternRoom(TiledRoom that)
	{
		this.setEasternRoom(that);
		that.setWesternRoom(this);
	}
	
	public void connectWesternRoom(TiledRoom that)
	{
		this.setWesternRoom(that);
		that.setEasternRoom(this);
	}
	
	public void setNorthernRoom(TiledRoom room)
	{
		northernNeighbor = room;
		setTileId(11/2, 0, 0, 1);
	}
	
	public void setSouthernRoom(TiledRoom room)
	{
		southernNeighbor = room;
		setTileId(11/2, 9-1, 0, 1);
	}
	
	public void setEasternRoom(TiledRoom room)
	{
		easternNeighbor = room;
		setTileId(11-1, 9/2, 0, 1);
	}
	
	public void setWesternRoom(TiledRoom room)
	{
		westernNeighbor = room;
		setTileId(0, 9/2, 0, 1);
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
	
	public static String getRandomRoomLayout()
	{
		Random random = new Random();
		File[] list = new File("./lvl").listFiles();
		return "./lvl/" + list[random.nextInt(list.length)].getName();
	}
}