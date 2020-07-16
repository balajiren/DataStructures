package ChatServer;

import ChatServer.UserStatus.UserStatusIndicator;

public class HomeUser implements IUser {

	public String userId;
	public String password;
	private UserStatusIndicator status;
	public HomeUser() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IUser getUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUserId()
	{
		return userId;
	}
	

	@Override
	public void setUserData(String userId,String password) {
		// TODO Auto-generated method stub
		this.userId = userId;
		this.password = password;
	}

	@Override
	public UserStatusIndicator getUserStatus(String userId) {
		// TODO Auto-generated method stub
		return status;
	}
	
	public void setUserStatus(UserStatusIndicator stat) {
		// TODO Auto-generated method stub
		status =stat;
	}
	public void receiveMessage(IUser user, String message)
	{
		System.out.print("Hello"+ this.getUserId() +" You got Message:"+ message+" from: "+ user.getUserId());
	}
	
	


}
