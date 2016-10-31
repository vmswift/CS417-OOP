// Group 3
// 10/5/2016
// Keyword in context conversion from C++

import java.util.Map;
import java.util.List;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.ArrayList;


public class KWICapp {
	
	public List<String> wordList = new ArrayList<String>();
	public Map<String, List<String> > kwicMap = new TreeMap<String, List<String> >(); //Sorted map
	
	//Read string input from the command line
	public void readWords(){
		
		System.out.println("Enter a line of text: ");
		Scanner console = new Scanner(System.in);
		String the_line = console.nextLine();
		
		for (String word : the_line.split(" ")){
				wordList.add(word);
			}
		console.close();
	}		
//		for (String text : "Today is a good day to take the dogs for a walk in the park".split(" ")){
//			wordList.add(text);
//		}

	//Create a keyword in context list
	public void creatwKWIC(){
		
		String first = "";
		String second = "";
		String key = "";
		String fourth = "";
		String fifth = "";
		String text = "";
		
		for (String element : wordList){
			if (first != ""){
				text = String.format("%s %s %s %s %s", first, second, key, fourth, fifth);
				
				if (!kwicMap.containsKey(key)){
					kwicMap.put(key, new ArrayList<String>());
				}	
				kwicMap.get(key).add(text);
			}
			first = second;
			second = key;
			key = fourth;
			fourth = fifth;
			fifth = element;
		}
	}
	
	//Print a keyword in context report
	public void printReport(){
		
		String header = "\n Keywords in Context\n---------------------\n";
		System.out.print(header);
		
		for (List<String> valueList : kwicMap.values()){
			for (String value : valueList){
				System.out.println(" " + value);
			}
		}
	}

	//Main method
	public static void main(String[] args) {

		KWICapp app = new KWICapp();
		
		app.readWords();
		app.creatwKWIC();
		app.printReport();
	}
}
