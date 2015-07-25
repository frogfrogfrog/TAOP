package chapter2.section1;

public class FindKMin {
	public static void main(String[] args){
//		int[] data1=new int[]{4,3,2,1,9,5,8,6,7};
//		quickSort(data1,0,data1.length-1);
//		for(int i:data1){
//			System.out.print(i);
//		}
//		System.out.println();
//		
//		int[] data2=new int[]{3,2,1,6,5,4};
//		quickSelect(data2,3,0,data2.length-1);
//		for(int i:data2){
//			System.out.print(i);
//		}
		
		int[] a1=new int[]{3,2,1};
		int[] a2=new int[]{3,2,4,5,1};
		int[] result=findKMinOfTwoArray(a1, a2, 6);
		for(int i:result){
			System.out.print(i+" ");
		}
	}
	public static void quickSort(int[] data,int start,int end){
		if(start<end){
			int pivot=data[start];
			int i=start+1;
			int j=end;
			while(true){
				while(i<=end && data[i]<pivot)
					i++;
				while(j>start && data[j]>pivot)
					j--;
				//经过计算i和j分别是本次循环中第一个大于和小于中间值的数
				if(i<j){
					int t=data[i];
					data[i]=data[j];
					data[j]=t;
				}else{
					break;
				}
			}
			int t=data[start];
			data[start]=data[j];
			data[j]=t;
			
			quickSort(data,start,j-1);
			quickSort(data,j+1,end);
		}
	}
	
	public static void quickSelect(int[] data,int k,int start,int end){
		if(start<end){
			int pivot=data[start];
			int i=start+1;
			int j=end;
			while(true){
				while(data[i]<pivot)
					i++;
				while(data[j]>pivot)
					j--;
				//经过计算i和j分别是本次循环中第一个大于和小于中间值的数
				if(i<j){
					int t=data[i];
					data[i]=data[j];
					data[j]=t;
				}else{
					break;
				}
			}
			int t=data[start];
			data[start]=data[j];
			data[j]=t;
			
			if(k<j+1){
				quickSort(data,start,j-1);
			}else if(k>j+1){
				quickSort(data,j+1,end);
			}
		}
	}
	
	
	public static int[] findKMinOfTwoArray(int[] array1,int[] array2,int k){
		int size1=array1.length;
		int size2=array2.length;
		quickSort(array1,0,size1-1);
		quickSort(array2,0,size2-1);
		int[] result=new int[k];
		if(size1*size2<k){
			return null;
		}
		for(int i=0;i<k;i++){
			result[i]=array1[i%size1]+array2[i/size1];
		}
		quickSort(result, 0, k-1);
		for(int i=0;i<size1;i++){
			if(i<=((k-1)%size1)){
				for(int j=((k-1)/size1+1);j<size2;j++){
					if(isBigThenArray(array1[i]+array2[j],result)){
						break;
					}
				}
			}else{
				for(int j=((k-1)/size1);j<size2;j++){
					if(isBigThenArray(array1[i]+array2[j],result)){
						break;
					}
				}
			}
		}
		return result;
	}
	
	public static boolean isBigThenArray(int a,int[] kMin){
		int size=kMin.length;
		if(a>=kMin[size-1]){
			//a比数组中最大的数要大
			return true;
		}
		int i=0;
		for(;i<size;i++){
			if(a<=kMin[i]){
				//找到存放的位置了
				break;
			}
		}
		for(int j=i+1;j<size;j++){
			kMin[j]=kMin[j-1];
		}
		kMin[i]=a;
		return false;
	}
}
