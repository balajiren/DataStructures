package ChatServer;

import java.util.List;

public interface IParticipant {
	public void Update(IUser from ,String message);
	public void add(IUser user);
	public void remove(String userId);
    public List<IUser> GetParticipants();

}
