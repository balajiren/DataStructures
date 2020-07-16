package ChatServer;

import java.util.List;

public abstract class Conversation {

	public Conversation() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract void addParticipant(IUser user);
	public abstract void removeParticipant(String user);
	public abstract void StartConversation(IUser user1,Message msg);
	public abstract List<IUser> GetParticipants();


}
