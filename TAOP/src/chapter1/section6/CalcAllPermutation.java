package chapter1.section6;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如输入字符串abc，则输出由字符a、b、c 所能排列出来的所有字符串
 * abc、acb、bac、bca、cab 和 cba。
 * @author yzx12
 *
 */
public class CalcAllPermutation {
	public static void main(String[] args){
		String a="bac";
		char[] c=a.toCharArray();
		do{
			System.out.println(c);
		}while(nextPermutation(c));
	}
	public static boolean nextPermutation(char[] c){
		//先找升序的首位，即从右往前找，第一个出现c[i]<c[i+1]
		int size=c.length;
		int i=size-2;
		while(i>=0 && c[i]>=c[i+1] ){
			i--;
		}
		if(i<0)
			return false;
		int j=size-1;
		while(c[j]<=c[i]){
			j--;
		}
		
		//交换
		char t=c[i];
		c[i]=c[j];
		c[j]=t;
		
		//i+1 到最后一个反转
		int start=i+1;
		int end=size-1;
		while(start<end){
			t=c[start];
			c[start++]=c[end];
			c[end--]=t;
		}
		return true;
	}
	
	
}
