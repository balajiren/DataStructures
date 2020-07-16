package TennisTournament;

import java.util.List;
import java.util.PriorityQueue;

public class TournamentGraph  {

	public List<Player> _players;
	public List<Match> _matches;
	public PriorityQueue<Player> ranking;
	
	TournamentGraph(List<Player> players, List<Match> matches)
	{
		_players = players;
		_matches = matches;
		 ranking = new PriorityQueue<Player>();
				
	}
	
	/*public Player GetWinner()
	{
		return null;
		
	}
	
	public Player GetRank(Player player)
	{
		return player;
		
	} */

}
