package chapter1.section7;

import java.io.UnsupportedEncodingException;

public class Practice {
	public static void main(String[] args) throws UnsupportedEncodingException{
		System.out.println(firstOccurredOnceChar("  "));
	}
	public static char firstOccurredOnceChar(String str){
		int max=1<<8;
		int[] counter=new int[max];
		int size=str.length();
		for(int i=0;i<size;i++){
			if(str.charAt(i)<=max-1 && str.charAt(i)>=0)
				counter[str.charAt(i)]++;
		}
		for(int i=0;i<max;i++){
			if(counter[i]==1)
				return (char) i;
		}
		return ' ';
	}
}
