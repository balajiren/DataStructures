package JukeBox;

public class JukeBox {
	
	PlayList _playList;
	boolean _isTurned = false;
	
	JukeBox()
	{
		
	}
	public void PlaySong(PlayList p)
	{
		_isTurned = true;
	}
	public void Stop()
	{
		_isTurned = false;
	
	}
	
	public void DisplaySongs()
	{
		
	}

}
