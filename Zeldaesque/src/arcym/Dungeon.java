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
}