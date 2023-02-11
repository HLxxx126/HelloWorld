public class Store2 {
  // instance fields
  String productType;
  double price;
  
  // constructor method
  public void Store(String product, double initialPrice) {  
    productType = product;
    price = initialPrice;
  }
  
  public void increasePrice(double priceToAdd){
    double newPrice = price + priceToAdd;
    price = newPrice;
  }
  
  // main method
  public static void main(String[] args) {
    Store lemonadeStand = new Store("lemonade", 3.75);
    lemonadeStand.increasePrice(1.5);
    System.out.println(lemonadeStand.price);
  }
}