package chapter1.section4and5;

public class Palindrome {
	public static void main(String[] args){
		System.out.println(longestPalindrome("dabadabad"));
	}
	
	public static boolean isPalindrome(String str){
		if(str==null)
			return false;
		int head=0,tail=str.length()-1;
		while(head<tail){
			if(str.charAt(head)!=str.charAt(tail))
				return false;
			head++;
			tail--;
		}
		return true;
	}
	
	/**
	 * 使用Manacher算法计算最长回文子串的长度
	 * @param str
	 * @return
	 */
	public static int longestPalindrome(String str){
		String trans="";
		for(int i=0;i<str.length();i++){
			trans=trans+'#'+str.charAt(i);
		}
		trans+='#';
		System.out.println(trans);
		int id=0;
		int mx=0;  //mx=id+P[id] 即最大回文子串的边界
		int[] p=new int[trans.length()];
		int length=trans.length();
		for(int i=0;i<length;i++){
			if(mx>i)
				p[i]=min(mx-i,p[2*id-i]);
			else
				p[i]=1;
			while(i-p[i]>=0 && i+p[i]<length && trans.charAt(i-p[i])==trans.charAt(i+p[i]))
				p[i]++;
			if(p[i]+i>mx){
				mx=p[i]+i;
				id=i;
			}
		}
		
		int max=0;
		for(int i=0;i<p.length;i++){
			if(p[i]>max){
				max=p[i];
			}
		}
		return max-1;
	}
	public static int min(int a,int b){
		return a<b?a:b;
	}
}
