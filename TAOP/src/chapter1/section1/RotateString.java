package chapter1.section1;

/**
 * 1.1旋转字符串
 * 给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，
 * 如把字符串“abcdef”前面的2个字符'a'和'b'移动到字符串的尾部，
 * 使得原字符串变成字符串“cdefab”。请写一个函数完成此功能，
 * 要求对长度为n的字符串操作的时间复杂度为 O(n)，空间复杂度为 O(1)。
 * @author yzx12
 *
 */

public class RotateString {
	public static void main(String[] args){
		//测试使用循环左移的方法
		RotateString rs=new RotateString();
		String str="abcdefg";
		char[] s=str.toCharArray();
		rs.leftRotateString(s, 2);
		System.out.println(s);
		
		//测试使用字符串反转的方法
		char[] s1=str.toCharArray();
		rs.rotateString(s1, 2);
		System.out.println(s1);
	}
	
	/**
	 * 一次旋转一个字符
	 */
	public void leftShiftOne(char[] s){
		int n=s.length;
		char t=s[0];
		for(int i=1;i<n;i++){
			s[i-1]=s[i];
		}
		s[n-1]=t;
	}
	/**
	 * 
	 * @param s 要旋转的字符串
	 * @param m 移动到尾部的m个字符
	 * @return
	 */
	public boolean leftRotateString(char[] s,int m){
		int n=s.length;	
		if(n<=0 || m<0){
			return false;
		}
		m%=n;
		if(m==n){
			return true;
		}else{
			while(m>0){
				this.leftShiftOne(s);
				m--;
			}
			return true;
		}
	}
	
	/**
	 * 反转字符串
	 * @param s
	 * @param from
	 * @param to
	 */
	public void ReverseString(char[] s,int from,int to){
		while(from<to){
			char t=s[from];
			s[from++]=s[to];
			s[to--]=t;
		}
	}
	/**
	 * 旋转字符串
	 * @param s
	 * @param m
	 */
	public boolean rotateString(char[] s,int m){
		int n=s.length;
		if(m<0 || n<=0){
			return false;
		}
		m%=n;
		this.ReverseString(s, 0, m-1);
		this.ReverseString(s, m, n-1);
		this.ReverseString(s, 0, n-1);
		return true;
	}
}
