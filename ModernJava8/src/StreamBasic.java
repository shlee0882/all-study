
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamBasic {

	public static void main(String... args) {
		// 자바 7
//		getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

//		System.out.println("---");

		getLowCaloricDishesNames(Dish.menu);
		
		// 자바 8
//		getLowCaloricDishesNames(Dish.menu).forEach(System.out::println);
	}

	public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {
		List<Dish> lowCaloricDishes = new ArrayList<>();
		for (Dish d : dishes) {
			if (d.getCalories() < 400) {
				lowCaloricDishes.add(d);
			}
		}
		List<String> lowCaloricDishesName = new ArrayList<>();
		Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
			@Override
			public int compare(Dish d1, Dish d2) {
				return Integer.compare(d1.getCalories(), d2.getCalories());
			}
		});
		for (Dish d : lowCaloricDishes) {
			lowCaloricDishesName.add(d.getName());
		}
		return lowCaloricDishesName;
	}

	public static List<String> getLowCaloricDishesNames(List<Dish> dishes) {
		
		List<String> list = dishes.stream()			
				.filter(a -> {
					System.out.println("filtering: " + a.getName());
					return a.getCalories() > 300;
				})	// 필터한 요리명 출력
				.map(a -> {
					System.out.println("mapping: "+a.getName());
					return a.getName();
				}) // 추출한 요리명 출력
				.limit(3)										
				.collect(Collectors.toList());				
		
		System.out.println(list);
		return list;
	}

}
