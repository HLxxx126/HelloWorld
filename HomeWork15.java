package hl;

public class HomeWork15 {
	public static void main(String[] args) {
		Book book = new Book("绵羊游戏", 280);
		book.info();
		book.updatePrice();// 更新价格
		book.info();
	}
}

class Book {
	String name;
	double price;

	public Book(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public void updatePrice() {
		// 如果方法中没有price局部变量，this可省略
		if (this.price > 150) {
			this.price = 150;
		} else if (this.price > 100) {
			this.price = 100;
		}
	}

	public void info() {
		System.out.println("书名 = " + this.name + " 价格 = " + this.price);
	}
}
/*
 * class Book{ public double updatePrice(double price) { if(price >150) { return
 * 150; }else if(price > 100 && price < 150) { return 100; }return price; } }
 */