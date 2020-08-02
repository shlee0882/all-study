
import java.util.List;
import java.util.Optional;

public class Finding {
	static List<Dish> menu = Dish.menu;

	public static void main(String... args) {

		System.out.println(isVegetarian());
		System.out.println(isLowCalory());
		System.out.println(isHighCalory());

//		Optional<Dish> dish = findVegetarianDish();
//		dish.ifPresent(d -> System.out.println(d.getName()));
		Optional<Dish> dish = findFirstDish();
		dish.ifPresent(d -> System.out.println(d.getName()));
		System.out.println(findFirstDish());
	}

	private static boolean isVegetarian() {
		return menu.stream()
				.anyMatch(Dish::isVegetarian);
	}

	private static boolean isLowCalory() {
		return menu.stream()
				.allMatch(d -> d.getCalories() < 1000);
	}

	private static boolean isHighCalory() {
		return menu.stream()
				.noneMatch(d -> d.getCalories() >= 1000);
	}

	private static Optional<Dish> findAnyVegeDish() {
		return menu.stream()
				.filter(Dish::isVegetarian)
				.findAny();
	}
	
	private static Optional<Dish> findFirstDish() {
		return menu.stream()
				.filter(Dish::isVegetarian)
				.findFirst();
	}
	
	

}
