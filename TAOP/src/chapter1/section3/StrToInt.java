package chapter1.section3;

public class StrToInt {
	public static void main(String[] args) {
		
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		
		System.out.println(strToInt("10522545459"));
		System.out.println(strToInt("2147483646"));
		System.out.println(strToInt("2147483647"));
		System.out.println(strToInt("324"));
		
		System.out.println(strToInt("-10522545459"));
		System.out.println(strToInt("-2147483647"));
		System.out.println(strToInt("-2147483648"));
		System.out.println(strToInt("-25"));
	}

	public static int strToInt(String str) {
		int max=Integer.MAX_VALUE;
		int min=Integer.MIN_VALUE;
		int result = 0;
		if (str == null)
			return 0;
		// 处理空格
		str.trim();
		int sign = 1;
		int i = 0;
		if (str.charAt(i) == '+' || str.charAt(i) == '-') {
			if (str.charAt(i) == '-')
				sign = -1;
			i++;
		}

		while (i<str.length() && isDigit(str.charAt(i))) {
			
			int current = str.charAt(i) - '0';
			if (sign == 1 && (result > max / 10 
					|| (result == max / 10 && current > max % 10))) {
				result = max;
				break;
			}
			if (sign == -1 && (-result < min / 10
					|| (-result == min / 10 && current < min % 10))) {
				result=min;
				break;
			}
			result=result*10+current;
			i++;
		}

		return result*sign;
	}

	public static boolean isDigit(char c) {
		if(c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6'
				|| c=='7' || c=='8' || c=='9')
			return true;
		return false;
	}
}
