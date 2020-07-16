package ChatServer;

import ChatServer.UserStatus.UserStatusIndicator;

public interface IUser {

	public IUser getUser(String userId);
	public String getUserId();
	public void setUserData(String userId,String password);
	public UserStatusIndicator getUserStatus(String userId);
	public void setUserStatus(UserStatusIndicator status);
	public void receiveMessage(IUser user, String message);
	//public void  setUserStatus(UserStatusIndicator flag);
}
