package list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Random r = new Random();

		for (int i = 0; i < 70; i++) {
			list.add(r.nextInt(100));
		}
		
		System.out.println("List: \n" + list);
		
		
		ListIterator<Integer> it = list.listIterator(list.size());
		
		while(it.hasPrevious()) {
			it.previous();
			if (it.previousIndex() % 2 != 0) {
				it.remove();
			}
		}
		
		System.out.println("List: \n" + list);

	}

}
