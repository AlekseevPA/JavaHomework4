package set;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Random rnd = new Random();

		Set<Integer> a = new HashSet<>();
		Set<Integer> b = new HashSet<>();

		for (int i = 0; i < 10; i++) {
			a.add(rnd.nextInt(99));
			b.add(rnd.nextInt(99));
		}

		System.out.println("A:\n" + a);
		System.out.println("B:\n" + b);
		System.out.println("Intersect:\n" + intersect(a, b));
		System.out.println("Union:\n" + union(a, b));

	}

	public static Set<Integer> intersect(Set<Integer> a, Set<Integer> b) {
		Set<Integer> result = new HashSet<>(a);
		result.retainAll(b);

		return result;
	}

	public static Set<Integer> union(Set<Integer> a, Set<Integer> b) {
		Set<Integer> result = new HashSet<>(a);
		result.addAll(b);

		return result;
	}

}
