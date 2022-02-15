package minandMaxbyMathfuntion;

public class FindMaxandMinwithoperators {
	
	public static void main(String string[]) {
		findMaxandMin(34, 870, 3);
		
	}
	
	public static void findMaxandMin(int a, int b , int c) {
		int get_max = Math.max(a, Math.max(b, c));
		int get_min = Math.min(a, Math.min(c, b));
		System.out.println("Max is :- "+get_max+" Min is : "+get_min);
	}

}
