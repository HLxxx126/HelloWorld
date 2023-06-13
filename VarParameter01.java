public class VarParameter01{
	public static void main(String[]args) {
		HspMethod hsp = new HspMethod();
		System.out.println(hsp.sum(1,2,3));
		System.out.println(hsp.sum(20,77));
	}
}
class HspMethod {
	public int sum(int ...nums) {
		int res =0;
		for(int n = 0 ; n < nums.length ; n ++) {	
			res += nums[n];
		}
		return res;
	}
}