import java.io.*;
import java.util.*;
public class SwitchSort{

	public static int[] switch_sort(int[] arr){
		if(arr.length < 2){
			return arr;
		}
		int max = arr[0];
		int min = arr[0];
		for( int i : arr){
			if( i < min ){
				min = i;
			}
			if( i > max ){
				max = i;
			}
		}
		int[] temp = new int[max-min+1];
		for( int i : arr){
			temp[i-min] = i;
		}
		int j = 0;
		for( int i : temp){
			if( i != 0 ){
			arr[j] = i;
			j++;
			}
		}
		return arr;
	}
	public static void main(String[] args){
		long time = System.currentTimeMillis();
		File file = new File("/usr/joseph/data.txt");
		Scanner input = new Scanner(file);
		String content = ;
		String[] stringy = content.split("\n");
		int[] inty = new int[stringy.length];
		for(int i = 0; i < stringy.length; i++){
			inty[i] = Integer.parseInt(stringy[i]);
		}
		int[] result = switch_sort(inty);
		for( int i : result){
		System.out.println(i);
		}
		System.out.println(System.currentTimeMillis() - time);
	}


}
