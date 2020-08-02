import java.util.*;

public class Main{

	public static class Apple {
		private int weight = 0;
		private String color = "";
		
		public Apple(int weight, String color) {
			this.weight = weight;
			this.color = color;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		@SuppressWarnings("boxing")
		@Override
		public String toString() {
			return String.format("Apple{color='%s', weight=%d}", color, weight);
		}
	}

	enum Color{
		 RED
		,GREEN
	}
	
	public interface ApplePredicate{
		boolean test(Apple apple);
	}
	
	public static class AppleGreenColorPredicate implements ApplePredicate {
		public boolean test(Apple apple) {
			return (Main.Color.GREEN.name()).equals(apple.getColor());
		}
	}
	
	public static class AppleHeavyWeightPredicate implements ApplePredicate {
		public boolean test(Apple apple) {
			return apple.getWeight() > 150;
		}
	}


	private static final List<Apple> inventory = Arrays.asList(
				new Apple(80, "GREEN")
			  , new Apple(155, "GREEN")
			  , new Apple(120, "RED")
			);

	
	public static void main(String[] args) {

		System.out.println(filterGreenApples(inventory));
		System.out.println(filterApplesByColor(inventory, Color.RED));
		System.out.println(filterApplesAllAttr(inventory, Color.GREEN, 100, true));
		System.out.println(filterApples(inventory, new AppleHeavyWeightPredicate()));
		System.out.println(filterApples(inventory, new AppleGreenColorPredicate()));
		System.out.println(redApples);
		System.out.println(result);
	}
	
	
	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (Color.GREEN.name().equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (color.name().equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}
	
	public static List<Apple> filterApplesAllAttr(List<Apple> inventory, Color color
			, int weight, boolean flag) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (color.name().equals(apple.getColor()) && flag == true) {
				if(apple.getWeight() > weight) {
					result.add(apple);
				}
			}
		}
		return result;
	}
	
	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory) {
			if(p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	
	static List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
		public boolean test(Apple apple) {
			return Color.RED.name().equals(apple.getColor());
		}
	});
	
	static List<Apple> result = filterApples(inventory, (Apple apple) -> Color.RED.name().equals(apple.getColor()));
	
}
