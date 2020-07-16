package ChatServer;

import java.util.ArrayList;
import java.util.List;

public class TwoWayConversation extends Conversation {

	static final List<IUser> participants = new ArrayList<IUser>();
	public TwoWayConversation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addParticipant(IUser user) {
		participants.add(user);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeParticipant(String user) {
		// TODO Auto-generated method stub
		for(IUser u : participants)
		{
			if(u.getUser(user)!=null)
			{
				participants.remove(u);
			}
		}
		
	}
	@Override
	public List<IUser> GetParticipants()
	{
		return participants;
	}

	@Override
	public void StartConversation(IUser user1,Message message) {
		
		for(IUser u : participants)
		{
			if(u.getUserId() != user1.getUserId())
			   u.receiveMessage(user1, message.message);
		}
		
	}

}
