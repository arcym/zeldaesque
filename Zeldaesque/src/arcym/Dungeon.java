package arcym;

import org.newdawn.slick.SlickException;

public class Dungeon
{
	public TiledRoom room;
	
	public Dungeon() throws SlickException
	{
		room = new TiledRoom("lvl/blank.tmx");
		room.setNorthernNeighbor(new TiledRoom("lvl/blank.tmx"));
		room.setSouthernNeighbor(new TiledRoom("lvl/blank.tmx"));
		room.setEasternNeighbor(new TiledRoom("lvl/blank.tmx"));
		room.setWesternNeighbor(new TiledRoom("lvl/blank.tmx"));
	}
	
	public void render()
	{
		room.render(0, 0);
	}
	
	public void move(Direction direction)
	{
		if(direction == Direction.NORTH)
		{
			room = room.northernNeighbor;
		}
		else if(direction == Direction.SOUTH)
		{
			room = room.southernNeighbor;
		}
		else if(direction == Direction.EAST)
		{
			room = room.easternNeighbor;
		}
		else if(direction == Direction.WEST)
		{
			room = room.westernNeighbor;
		}
	}
}