package uniqueCharacter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueCharacter {
	
	 HashMap<String,Set<Character>> cacheList = new HashMap<>(); 
	 /**
	  * method to find number of unique character in string.
	  * @param string
	  * @return int count of unique character
	  * @throws Exception
	  */
	 public int uniqueCharacter(String string) throws Exception
	 {
		 Set<Character> uniqueCharacterList = new HashSet<Character>();
		 if(string==null)
		 {
			 throw new Exception("null input string");
		 }
		 if(isStringExist(string))
		 {
			 return cacheList.get(string).size();
		 }
		 else
		 {
		 for(int str=0; str<string.length();str++)
		 {
			 uniqueCharacterList.add(string.charAt(str));
			 
		 }
		 cacheList.put(string, uniqueCharacterList);
		 return uniqueCharacterList.size();
		 }
		 
	 }
	 /**
	  * method to check whether string present in cache or not
	  * @param string
	  * @return true if exist else false
	  */
	 public boolean isStringExist( String string)
	 {
		 if(cacheList.get(string)!=null)
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
		 
	 }

}
