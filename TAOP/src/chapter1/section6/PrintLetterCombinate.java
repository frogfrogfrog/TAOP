package chapter1.section6;

import java.util.Stack;

public class PrintLetterCombinate {
	public static void main(String[] args) {
		String str="abcde";
		combination(str);
	}
	
	public static void combination(String str){
		int size=str.length();
		
		for(int i=1;i<=size;i++){
			Stack<Character> stack=new Stack<Character>();
			combination(str, 0, i, stack);
			System.out.println();
		}
	}
	/**
	 * 
	 * @param str
	 * @param pos
	 *            需要被选中的字符的位置
	 * @param num
	 *            还需要选中的字符
	 * @param stack
	 *            存放当前选中的字符
	 */
	public static void combination(String str, int pos, int num,
			Stack<Character> stack) {
		int size = str.length();

		if (num == 0) {
			boolean flag=true;
			System.out.print('(');
			for (char c : stack) {
				if(flag){
					System.out.print(c);
					flag=false;
				}else{
					System.out.print(',');
					System.out.print(c);					
				}
			}
			System.out.print(")");
			return;
		}
		if(pos==size)
			return;

		stack.push(str.charAt(pos));
		combination(str, pos + 1,num-1,stack);

		stack.pop();
		combination(str, pos + 1,num,stack);
	}
}
