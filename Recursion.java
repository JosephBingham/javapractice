import java.util.*;
public class Recursion{
public static long fact(long num){
    if(num < 0){
	return 0;
    }
else if(num == 1 || num == 0){
	return 1;
	    }else{
return (num*fact(num-1));
    
    }
    }
public static void main(String[] agrs){
Scanner scan = new Scanner(System.in);
long a = scan.nextInt();
System.out.println(fact(a));

   }
}
