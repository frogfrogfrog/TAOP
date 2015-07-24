package chapter1.section6;

/**
 * 1、已知字符串里的字符是互不相同的，现在任意组合，比如ab，则输出aa，ab，ba，bb，编程按照字典序输出所有的组合。
 * @author yzx12
 *
 */
public class FullPermutation {
	public static void main(String[] args){
		String a="abc";
		char[] c=a.toCharArray();
		char[] temp=new char[c.length];
		printFullPermutation(c, temp, 0);
		
		
	}
	
	/**
	 * 
	 * @param c：源字符串
	 * @param pos：打印的当前下标
	 * @param temp：保存本次要打印的字符串
	 */
	public static void printFullPermutation(char[] c,char[] temp,int pos){
		int size=c.length;
		if(pos==size){
			//说明当前打印位置已经到字符串末尾。
			System.out.println(temp);
		}else{
			for(int i=0;i<size;i++){
				temp[pos]=c[i];
				printFullPermutation(c, temp, pos+1);
			}
		}
	}
}
