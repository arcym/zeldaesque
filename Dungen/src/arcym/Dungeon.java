package arcym;

import org.newdawn.slick.SlickException;

public class Dungeon
{
	public TiledRoom room;
	
	public Dungeon() throws SlickException
	{
		room = new TiledRoom("./lvl/blank.tmx");
		room.connectEasternRoom(new TiledRoom());
		room.connectWesternRoom(new TiledRoom());
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