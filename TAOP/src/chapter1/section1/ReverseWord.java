package chapter1.section1;

/**
 * 单词翻转。输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变，
 * 句子中单词以空格符隔开。为简单起见，标点符号和普通字母一样处理。例如，
 * 输入“I am a student.”， 则输出“student. a am I”。
 * 
 * 思路，先反转整个字符串变成 “.tneduts a ma I”,再对每个单词翻转
 * @author yzx12
 *
 */

public class ReverseWord {
	public static void main(String[] args){
		String a="I am a student.";
		String b=myReverse(a);
		System.out.println(b);
	}
	public static String reverseWord(String str){
		String[] splitStr=str.split("\\s+");
		StringBuilder sb=new StringBuilder();
		int size=splitStr.length;
		for(int i=0;i<size;i++){
			if(size-1==i){
				sb.append(splitStr[size-i-1]);
			}else{
				sb.append(splitStr[size-i-1]+" ");
			}
		}
		return sb.toString();
	}
	
	public static String myReverse(String str){
		str=reverseSentence(str);
		char[] clist=str.toCharArray();
		int n=clist.length;
		int begin = 0,end=0;
		while(begin<n){
			if(clist[begin]==' '){
				begin++;
				end++;
				continue;
			}
			//碰到空格或者达到末尾了
			if(end==n || clist[end]==' '){
				end--;
				reverseWord(clist,begin,end);
				begin=++end;
			}else{
				end++;
			}
			
		}
		return String.valueOf(clist);
	}
	/*
	 * 翻转其中的一个单词
	 */
	public static void reverseWord(char[] s,int from,int to){
		while(from<to){
			char t=s[from];
			s[from++]=s[to];
			s[to--]=t;
		}
	}
	
	public static String reverseSentence(String str){
		char[] clist=str.toCharArray();
		int end=clist.length-1;
		int start=0;
		while(start<end){
			char t=clist[start];
			clist[start++]=clist[end];
			clist[end--]=t;
		}
		return String.valueOf(clist);
	}
}
