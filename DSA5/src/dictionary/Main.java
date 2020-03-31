package dictionary;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {

	public static void main(String[] args) throws org.json.simple.parser.ParseException {
	
		Scanner inputScanner = new Scanner(System.in);
		
        JSONParser parser = new JSONParser();
        List<Data> sortedAccordingToKeys = new ArrayList<>();
        JSONObject jsonObject = null;
        BinarySearchTree binarySearchTree = null;
        try {
            jsonObject = (JSONObject) parser.parse(new FileReader("src\\dictionary\\input.json"));
            binarySearchTree = new BinarySearchTree(jsonObject);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found ");
            e.printStackTrace();
        } catch (IOException e) {
        	System.out.println("File I/O Exception ");
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
        
        String choice;
        String key, secondKey;
        String value;
        do
        {
        	System.out.println("\n0. Display the key value pairs in sorted order.");
        	System.out.println("1.Add a key value pair");
        	System.out.println("2. Delete a key value pair.");
        	System.out.println("3. Find value at particular key.");
        	System.out.println("4. Get the sorted key value pair between two keys.");
        	System.out.println("5. Exit");
        	
        	System.out.print("\nEnter your choice : ");
        	choice = inputScanner.nextLine();
        	
        	switch(choice)
        	{
        	case "0" : 
        		System.out.println("\nThe key value pairs in sorted order are : ");
                binarySearchTree.printTree(binarySearchTree.root);
        		break;
        	case "1" : 
        		try {
        		System.out.print("\nEnter the key of the key value pair to be add: ");
        		key = inputScanner.nextLine();
        		System.out.print("\nEnter the value of the key value pair to be add: ");
        		value = inputScanner.nextLine();
        		binarySearchTree.addKeyValuePair(key, value);
        		System.out.println("\nThe tree after addition is : ");
        		binarySearchTree.printTree(binarySearchTree.root);
        		}catch (Exception e) {
					System.out.println(e.getMessage());
				}
        		break;	
        	case "2" : 
        		try
        		{
        		System.out.print("\nEnter the key of the key value pair to be deleted : ");
        		key = inputScanner.nextLine();
        		binarySearchTree.deleteKeyValuePair(key);
        		System.out.println("\nThe tree after deletion is : ");
        		binarySearchTree.printTree(binarySearchTree.root);
        		}
        		catch (Exception e) {
					System.out.println(e.getMessage());
				}
        		break;
        		
        	case "3" : 
        		System.out.print("\nEnter the key whose value to be determined : ");
        		key = inputScanner.nextLine();
        		System.out.println("\n\nThe value at key \"" + key + "\" is " + binarySearchTree.getValueAtKey(key));
        		break;
        		
        	case "4" : 
        		System.out.print("\nEnter the key 1 : ");
        		key = inputScanner.nextLine();
        		System.out.print("Enter the key 2 : ");
        		secondKey = inputScanner.nextLine();
        		System.out.println("\n\nThe sorted tree between key \"" + key + "\" and key \"" + secondKey + "\" is : ");
                sortedAccordingToKeys = binarySearchTree.sortBetweenTwoKeyValue(key, secondKey);
                for(int i = 0; i < sortedAccordingToKeys.size(); i++)
                {
                	System.out.println("\"" + sortedAccordingToKeys.get(i).getKey() + "\" : " + sortedAccordingToKeys.get(i).getValue());
                }
        		break;
        	case "5" : 
        		System.out.println("Thank you ");
        		inputScanner.close();
        		break;
        	default : 
        	}
        	
        }while(!"5".equals(choice));
        
	}

}
