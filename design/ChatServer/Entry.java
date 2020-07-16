package ChatServer;

import ChatServer.UserStatus.UserStatusIndicator;

public class Entry {

	public static void main(String args[])
	{
		Entry entry = new Entry();
		entry.StartConversation();
	}
	
	public void StartConversation()
	{
		IUser user = new HomeUser();
		user.setUserData("balaji", "chennai");
		user.setUserStatus(UserStatus.UserStatusIndicator.OnLine);
		
		IUser user2 = new HomeUser();
		user2.setUserData("swathi", "chennai");
		user.setUserStatus(UserStatus.UserStatusIndicator.Offline);
		
		Conversation conv = new TwoWayConversation();
		conv.addParticipant(user);
		conv.addParticipant(user2);
		
		Message msg = new Message("Hello");
		conv.StartConversation(user, msg);
		
	  UserStatusIndicator ind =	user.getUserStatus(user.getUserId());
	  if(ind == UserStatusIndicator.OnLine)
	  {
		  
	  }
		
	}

}
