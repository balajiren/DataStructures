package DesignPatterns;

//Stargegy pattern is used to avoid code duplication and promote re-usability
//In Strategy pattern, a class behavior or its algorithm can be changed at run time. This type of design pattern comes under behavior pattern.

interface ISocialMediaStrategy 
{
    public void connectTo(String friendName);
}

class SocialMediaContext 
{
    ISocialMediaStrategy smStrategy;
 
    public void setSocialmediaStrategy(ISocialMediaStrategy smStrategy) 
    {
        this.smStrategy = smStrategy;
    }
 
    public void connect(String name) 
    {
        smStrategy.connectTo(name);
    }
}

class FacebookStrategy implements ISocialMediaStrategy {
	 
    public void connectTo(String friendName) 
    {
        System.out.println("Connecting with " + friendName + " through Facebook");
    }
}

public class Strategy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SocialMediaContext context = new SocialMediaContext();
		 
        // Setting Facebook strategy.
        context.setSocialmediaStrategy(new FacebookStrategy());
        context.connect("Lokesh");

	}

}
