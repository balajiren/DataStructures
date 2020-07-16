package String;
import java.util.*;


		  
   class Country {
    private String name;

    public Country(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return name;
    }
  }
  
    class CountryComparator implements Comparator<Country>
     {
       
       @Override
       public int compare(Country c1, Country c2)
       {
         return c1.getName().compareTo(c2.getName());
       }
       
     }
public class TreeSetSample {


       


  
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		   final Country specialA = new Country("Special A");
		   final Country specialB = new Country("Special B");
		   final Country specialC = new Country("Special C");
		   final Country specialD = new Country("Special D");
		   final Country specialE = new Country("Special E");
		
		   final Country countryA = new Country("Country A");
		   final Country countryB = new Country("Country B");
		   final Country countryC = new Country("Country C");
		   final Country countryD = new Country("Country D");
		   final Country countryE = new Country("Country E");
		 
		  
		 List<Country> availableCountries = new ArrayList<Country>();

		    availableCountries.add(countryE);
		    availableCountries.add(countryA);
		    availableCountries.add(countryC);
		    availableCountries.add(specialB);
		    availableCountries.add(countryB);
		    availableCountries.add(specialA);
		    availableCountries.add(countryD);
		
		    List<Country> specialCountries = new ArrayList<Country>();
		    specialCountries.add(specialA);
		    specialCountries.add(specialC);
		    specialCountries.add(specialD);
		    specialCountries.add(specialB);
		    specialCountries.add(specialE);
		    
		   List<Country> result = sortCountries(availableCountries,specialCountries);
	       System.out.println(result);

	

	}
	
	
	
	
	
	public static List<Country> sortCountries(List<Country> availableCountries, List<Country> specialCountries) {
      // fill in code here
      // have a set for available and special and available
      // if available has special then ad
      //d the special to the front of    res 
      List<Country> result = new ArrayList<Country>();
      if(null == availableCountries || null == specialCountries)
      {
        return result;
      }
      if(availableCountries.size() == 0)
      {
        return result;
      }
        
      if(specialCountries.size() == 0)
      {
        return availableCountries;
      }
        
      //result list

      Set<Country> available = new TreeSet<Country>(new CountryComparator());

      for(Country country : availableCountries)
      {
        available.add(country);
      
      }
      
      for(Country specialCountry : specialCountries)
      {
        //O(1) if hash set
        if(available.contains(specialCountry))
        {
          result.add(specialCountry);
          available.remove(specialCountry);
          
        }
      
      }
      

      for(Country  c : available)
      {
        result.add(c);
        
      }
      
      return result;
     
    }   
  }
                              
 
	
	

	

