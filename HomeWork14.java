package hl;

public class HomeWork14 {
	public static void main(String[] args) {
		String[] strs = { "SKM", "WTNB", "MGR", "FKZW" };
		A02 a02 = new A02();
		Integer index = a02.find("WTNB", strs);
		if (index != null) {
			if (index != -1) {
				System.out.println("查找的index = " + index);
			} else {
				System.out.println("查找的index不在数组中");
			}
		} else {
			System.out.println("strs的输入有误,数组不能为null，或者为{}");
		}
	}
}
class A02 {
	public Integer find(String findStr, String[] strs) {
		if (strs != null && strs.length > 0) {
			for (int i = 0; i < strs.length; i++) {
				if (findStr.equals(strs[i])) {
					return i;
				}
			}
			return -1;
		} else {
			return null;
		}
	}
}