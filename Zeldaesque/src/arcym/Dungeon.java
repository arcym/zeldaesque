package arcym;

import org.newdawn.slick.SlickException;

public class Dungeon
{
	public TiledRoom room;
	
	public Dungeon() throws SlickException
	{
		room = new TiledRoom("lvl/room1.tmx");
	}
	
	public void render()
	{
		room.render(0, 0);
	}
	
	public void move(Direction direction)
	{
		if(direction == Direction.WEST)
		{
			if(room.west == null)
			{
				try
				{
					room.west = new TiledRoom("lvl/room2.tmx");
					room.west.east = room;
				}
				catch (SlickException error)
				{
					System.out.println(error.getMessage());
				}
			}
			
			room = room.west;
		}
		else if(direction == Direction.EAST)
		{
			if(room.east == null)
			{
				try
				{
					room.east = new TiledRoom("lvl/room2.tmx");
					room.east.west = room;
				}
				catch (SlickException error)
				{
					System.out.println(error.getMessage());
				}
			}
			
			room = room.east;
		}
		else if(direction == Direction.NORTH)
		{
			if(room.north == null)
			{
				try
				{
					room.north = new TiledRoom("lvl/room2.tmx");
					room.north.south = room;
				}
				catch (SlickException error)
				{
					System.out.println(error.getMessage());
				}
			}
			
			room = room.north;
		}
		else if(direction == Direction.SOUTH)
		{
			if(room.south == null)
			{
				try
				{
					room.south = new TiledRoom("lvl/room2.tmx");
					room.south.north = room;
				}
				catch (SlickException error)
				{
					System.out.println(error.getMessage());
				}
			}
			
			room = room.south;
		}
	}
}