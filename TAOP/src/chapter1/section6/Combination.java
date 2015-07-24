package chapter1.section6;

import java.util.Stack;

/**
 * 2、如果不是求字符的所有排列，而是求字符的所有组合，应该怎么办呢？当输入的字符串中含有相同的字符串时，相同的字符交换位置是
 * 不同的排列，但是同一个组合。举个例子，如果输入abc，它的组合有a、b、c、ab、ac、bc、abc。
 * 
 * @author yzx12
 *
 */
public class Combination {
	public static void main(String[] args) {
		String str = "abc";
		combination(str);
	}

	public static void combination(String str) {
		Stack<Character> stack = new Stack<Character>();
		combination(str, 0,stack);
	}

	/**
	 * 
	 * @param str
	 * @param pos
	 *            需要被选中的字符的位置
	 * @param stack
	 *            存放当前选中的字符
	 */
	public static void combination(String str, int pos,Stack<Character> stack) {
		int size = str.length();

		// if(num==0){
		// for(char c:stack){
		// System.out.print(c);
		// }
		// System.out.println();
		// }
		if (pos == size) {
			for (char c : stack) {
				System.out.print(c);
			}
			System.out.println();

			return;
		}

		stack.push(str.charAt(pos));
		combination(str, pos + 1,stack);

		stack.pop();
		combination(str, pos + 1,stack);
	}
	
	public static void nonRecursion(String str){
		int N = str.length();
		int num = (int) Math.pow(2, N);
		for (int i = 1; i < num; i++) {
			for (int j = 0; j < N; j++) {
				if (((i >> j) & 1) == 1){
					System.out.print(str.charAt(j));
				}
			}
			System.out.println();
		}
	}
}
