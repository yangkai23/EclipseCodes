package hackerrank;

public class FactoryPatternFoodExample {
	public static void main(String[] args) {
		Food food = FoodFactory.getFood("coke");
		if(food!=null)
		System.out.println(food.getClass().getSimpleName());
		else
			System.out.println("NoSuchChild");
	}
	
}

interface Food {
	public String getType();
}

class Pizza implements Food {
	public String getType() {
		return "Someone ordered a Fast Food!";
	}
}

class Cake implements Food {

	public String getType() {
		return "Someone ordered a Dessert!";
	}
}

class FoodFactory {
	public static Food getFood(String order) {
		return order == null ? null : order.equals("cake") ? new Cake() : order.equals("pizza")?new Pizza() : null;

	}// End of getFood method

}// End of factory class