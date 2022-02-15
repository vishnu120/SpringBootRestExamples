package EvenNoByStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvenNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List<Integer> intList = List.of(15,20,48,63,49,27,56,32,9);
	     ArrayList<Integer> inlist = new ArrayList<>(Arrays.asList(15,20,48,56,63,49,27,56,32,9));  
	      // Calling the function to
	      // print the list of Even numbers
	      printEvenNumber(inlist);
	      

	}

	private static void printEvenNumber(ArrayList<Integer> intList) {
		// TODO Auto-generated method stub
		intList.stream().filter((x) -> ( x % 2 ==0) ).forEach((x) -> System.out.println(x));
		System.out.println("-------------------");
		intList.stream().sorted().forEach((x) -> System.out.println(x));
		System.out.println("---------distinct and sorted----------");
		intList.stream().sorted().distinct().forEach((x) -> System.out.println(x));
		System.out.println("---------find cube of odd number----------");
		intList.stream().filter( (x) -> x%2 !=0 ).map(x -> x*x*x).forEach((x) -> System.out.println(x));
		
	}

}
