package ChatServer;

import java.util.List;

public class Participants implements IParticipant {

	private final Conversation conv;
	public Participants(Conversation c) {
		// TODO Auto-generated constructor stub
		this.conv = c;
	}

	@Override
	public void Update(IUser fromUser ,String message) {
		// TODO Auto-generated method stub
	 List<IUser> users = conv.GetParticipants();
	 for(IUser u : users)
	 {
		 u.receiveMessage(fromUser, message);
	 }
		
	}

	@Override
	public void add(IUser user) {
		// TODO Auto-generated method stub
		conv.addParticipant(user);
	}

	@Override
	public void remove(String userId) {
		// TODO Auto-generated method stub
		conv.removeParticipant(userId);
		
	}

	@Override
	public List<IUser> GetParticipants() {
		// TODO Auto-generated method stub
		return conv.GetParticipants();
	}

}
