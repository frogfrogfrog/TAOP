package chapter2.section2;

import chapter2.section1.FindKMin;

public class FindTwoSum {
	public static void main(String[] args){
		int[] data={2,13,11,8,4,2,1,14};
		findSumOfK(data, 15);
	}
	
	public static void findSumOfK(int[] data,int sum){
		int size=data.length;
		FindKMin.quickSort(data, 0, size-1);
		int start=0;
		int end=size-1;
		while(start<end){
			int currSum=data[start]+data[end];
			if(currSum==sum){
				System.out.println(data[start]+"+"+data[end]+"="+sum);
				start++;
				end--;
//				break;
			}else if(currSum<sum){
				start++;
			}else{
				end--;
			}
		}
	}
}
