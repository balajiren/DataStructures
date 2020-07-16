package Problems;

import java.util.ArrayList;



public class SodaFillProblem {

	
	class Button
	{
		
		int min;
		int max;
		String button;
		int index;
		
		public Button(String name,int index,int buttonmin, int buttonmax)
		{
			button = name;
			min = buttonmin;
			max = buttonmax;
			index = index;
			
		}
		
	}
	
	static ArrayList<String> buttonCombinations = new ArrayList<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Button> buttons = new ArrayList<Button>();
		SodaFillProblem sp = new SodaFillProblem();
		SodaFillProblem.Button button1 = sp.new Button("A", 1, 200, 210);
		SodaFillProblem.Button button2 = sp.new Button("B",2, 500, 510);
		SodaFillProblem.Button button3 = sp.new Button("C", 3, 700, 710);
		buttons.add(button1);
		buttons.add(button2);
		buttons.add(button3);
		
		ArrayList<String> result = GetSodaCombinations(buttons,1,0,0,600);
		
		for(String res: result)
		{
			
			System.out.println(res);
		}
		

	}
	
	
	
	public static ArrayList<String> GetSodaCombinations(ArrayList<Button> buttons,int currentButtonIndex, int currentmax, int minLevel, int maxLevel)
	{
		
		if(currentButtonIndex >= buttons.size())
		{
			return buttonCombinations;
		}

		if (currentmax >= maxLevel)
		{
		
		  return buttonCombinations;
				
		}
		
	    Button currentButton = buttons.get(currentButtonIndex-1);
	    currentmax+=currentButton.max;
		buttonCombinations.add(currentButton.button);

		GetSodaCombinations(buttons,currentButton.index+1,currentmax,minLevel,maxLevel);
		currentmax= 0;
		GetSodaCombinations(buttons,currentButton.index+2,currentmax,minLevel,maxLevel);
	
	
		
		return buttonCombinations;
		
		
	}

}
