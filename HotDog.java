/**
 * Prints a menu of possible combination of 
 * toppings and their prices
 */
public class HotDog {
   /**
    * Prints all combos and their prices
    * 
    * @return the number of combos printed
    */
   public long printMenu() {
      //lists out all toppings
      String[] toppings = {"ketchup", "mustard","Chopped Onions","Tomato Wedges","Sweet Relish","Sport Peppers","Sauerkraut"};
      //gives prices more each topping
      int[] prices = {15,17,20,25,30,35,45};
      //set price of just plain hot dog
      int ogPrice = 99;
      //Counts number of possible combinations
      int total = 1 << toppings.length;
      //loops through all combos
      for (int combo = 0; combo < total; combo++){
          int price = ogPrice;
          String description = combo + " Dog in Bun";
          boolean first = true;
         //check toppings for the combo
          for (int i = 0; i <toppings.length; i++){
            if (((combo >> i) & 1)==1) {
               //adds with before listing first topping and a , before the rest
               description += first ? " with " :", ";
               description += toppings[i];
               //updates price based on which toppings were selected
               price += prices[i];
               //makes first false so that all following toppings get commas
               first = false;
            }
          }
          //prints out description of hot dog and its price
          System.out.println(description);
          System.out.printf("$%d.%02d%n",price/100,price % 100);
      }
      //shows how many combos were printed
      return total;

   }
   /**
    * Checks that all 128 combos were printed
    * 
    * @param args commad line arguments not used
    */
   
   public static void main( String [ ] args ) {
      HotDog obj = new HotDog( );
      long count = obj.printMenu( );
      assert count == 128;
   }
} 
