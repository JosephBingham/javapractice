package test;

public class Testing {

public static void main(String[] args){

	System.out.println(howManyWays(10));
	
	
	
}	
public static int howManyWays(int n){
	int count = 1;
	if(n < 2){
		return 0;
	}
	else{
		return count += howManyWays(n-2) + howManyWays(n-3);
	}
	
}
}