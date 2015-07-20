package chapter1.section2;
/**
 * 给定两个分别由字母组成的字符串A和字符串B，字符串B的长度比字符串A短。请问，如何最快地判断字符串B中所有字母是否都在字符串A里？
 * 比如，如果是下面两个字符串：String 1：ABCD String 2：BAD
 * 答案是true，即String2里的字母在String1里也都有，或者说String2是String1的真子集。
 * @author yzx12
 *
 */
public class StringContain {
	public static void main(String[] args){
//		String str1="ABCD";
//		String str2="BAD";
//		if(stringContain(str1, str2)){
//			System.out.println("字符串:\""+str2+"\"中所有字母都在字符串\""+str1+"\"里");
//		}
//		
//		String str3="ABCD";
//		String str4="BCE";
//		if(!stringContain(str3, str4)){
//			System.out.println("字符串:\""+str4+"\"中所有字母不都在字符串\""+str3+"\"里");
//		}
		
		String str1="ABCD";
		String str2="BAD";
		if(stringContainHash(str1, str2)){
			System.out.println("字符串:\""+str2+"\"中所有字母都在字符串\""+str1+"\"里");
		}
		
		String str3="ABCD";
		String str4="BCF";
		if(!stringContainHash(str3, str4)){
			System.out.println("字符串:\""+str4+"\"中所有字母不都在字符串\""+str3+"\"里");
		}
	}
	
	/**
	 * 使用素数法，让字母与素数一一对应
	 * @param str1
	 * @param str2
	 * @return 如果字符串str2中的字母都在str1中，返回true
	 */
	public static boolean stringContain(String str1,String str2){
		final int prime[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,61, 67, 71, 73, 79, 83, 89, 97, 101};
		int product=1;
		for(int i=0;i<str1.length();i++){
			int diff=str1.charAt(i)-'A';
			if(diff<=25 && diff>=0){
				if(product%prime[diff]!=0){
					product*=prime[diff];
				}
			}
		}
		for(int i=0;i<str2.length();i++){
			int diff=str2.charAt(i)-'A';
			if(diff<=25 && diff>=0){
				if(product%prime[diff]!=0){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 使用哈希法，计算字符串签名
	 * @param str1
	 * @param str2
	 * @return 如果字符串str2中的字母都在str1中，返回true
	 */
	public static boolean stringContainHash(String str1,String str2){
		int hash=0;
		for(int i=0;i<str1.length();i++){
			int diff=str1.charAt(i)-'A';
			hash |=(1<<diff);
		}
		for(int i=0;i<str2.length();i++){
			int diff=str2.charAt(i)-'A';
			if((hash & (1<<diff)) ==0){
				return false;
			}
		}
		return true;
	}
	
}
