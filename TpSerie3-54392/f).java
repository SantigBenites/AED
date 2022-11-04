
public class Test {

	public static void main(String[] args) {
		
		Saco bag1 = new Saco();
		bag1.Add(5);
		bag1.Add(1);
		bag1.Add(5);
		Saco bag2 = new Saco();
		bag2.Add(2);
		bag2.Add(5);
		bag1 = bag1.stackUnite(bag2);
		bag1.get(5);
		int howmany = bag1.howMany(5);
		System.out.print(howmany);
		
	}

}
