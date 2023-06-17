package hl;

public class HomeWork13 {
  public static void main(String[]args) {
	  A01 a01 = new A01();
	  double[]arr = {2.3 , 4.5 , 5.9};
	  Double res = a01.max(arr);
	  if(res  != null) {
	System.out.println("arr的最大值= " + a01.max(arr));
  }else {
	  System.out.println("arr的输入有误,数组不能为null，或者为{} ");
  }
  }
}
class A01{
	public Double max (double[] arr) {
		if(arr != null && arr.length > 0) {
		double max = arr [0];
		for(int i = 1; i < arr.length ;i++) {
			if (arr[i] > max){
				max = arr[i];	
			} 
		}
		return max;
		}else {
			return null;
		}
	}
}