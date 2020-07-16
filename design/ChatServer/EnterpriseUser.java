package ChatServer;

import ChatServer.UserStatus.UserStatusIndicator;

public class EnterpriseUser implements IUser {

	public String userId;
	public String password;
	private UserStatusIndicator status;

	public EnterpriseUser(String u, String p) {
		// TODO Auto-generated constructor stub
		userId = u;
		password = p;
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
		System.out.print("Hello"+ userId +" You got Message:"+ message+" from: "+ user.getUserId());
	}
	

}
