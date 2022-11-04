
public class Saco {
	
	private static final int Capacity = 8;
	private int[] theStack;
	private int top ;
	
	/*
	 * Constructor that creates a Saco object it as a initial capacity of 8
	 * and a integer array of name theStack
	 */
	
	public Saco() {
		
		theStack = new int[Capacity];
		top =-1;
		
	}
	/*in this method its added a integer i to theStack of a object Saco
	 * 
	 * @param i integer that is going to be added to theStack
	 */
	
	public void Add(int i) {
		
		if(top+1==this.theStack.length) {
			grow();
		}
		this.top++;
		this.theStack[top] = i;
		
	}
	
	
	public void print() {
		for(int i=0;i<=this.theStack.length-1;i++) {
			System.out.print(this.theStack[i]);
		}
		System.out.println();
	}
	
	
	public int size() {
	int counter = 0;
		for(int i= 0;i<=this.theStack.length-1;i++) {
			if(this.theStack[i]!=0) {
				counter++;
			}
		}
	return counter;
	}
	
	/* this method is called in the function Add(i), it is used when theStack doesn't 
	 * have space to new integer to be added to it, it make that the size of theStack 
	 * is multiplied by 2
	 * 
	 */

	public void grow() {
		
		int[] newStack = new int[this.theStack.length *2];
		for(int i=0;i<this.theStack.length;i++) {
			newStack[i] = this.theStack[i];
		}
		this.theStack = newStack;
	}
	/**
	 * This method checks if an integer a is present in theStack of a Saco
	 * 
	 * @param a	integer that the method is going to check if is present in the theStack of Saco
	 * 
	 * @return returns a boolean that represent if a is present or not in theStack
	 */
	
	public boolean check(int a) {
		
		for(int i=0;i<=this.theStack.length-1;i++) {
			if(this.theStack[i]==a) {
				return true;
			}
		}
	return false;
	} 
	
	/**
	 * This method uses the method check(a) to check if a is present in theStack of a 
	 * Saco, then if it is present if substitutes the position where a was with null
	 * 
	 * @param a the integer that is going to be substituted and returned if it is present on theStack
	 * 
	 * @return returns a if a is present on theStack and returns 0 if it is not present
	 */
	
	public int get(int a) {
		int i=0;
		int temp =-1;
		if(check(a)) {
			while(this.theStack[i]!=a) {
				i++;
			}
			temp = this.theStack[i];
			this.theStack[i]=0;
			return temp;
		}else {
			return temp;
		}
	}
	
	/**
	 * this method checks how many of a certain integer a is present on theStack of a Saco
	 * 
	 * @param a the integer that is going to be searched for in theSatck of Saco
	 * 
	 * @return and integer representing how many of a is present on theStack of Saco
	 */
	
	public int howMany(int a) {
		int counter=0;
		if(check(a)) {
			for(int i=0;i<=this.theStack.length-1;i++) {
				if(this.theStack[i]==a) {
					counter++;
				}
			}
		}
		return counter;
	}
	
	/**
	 * this method unites 2 theStacks of 2 Sacos into one and substitutes the theStack of the first Saco with the result of the union
	 * 
	 * @param stack2 the second Saco which theStack is going to be added to the first theStack of the first Saco
	 * 
	 * @return A Saco white the the?Stack of that Saco is the result of the union of the theStack of the 2 Sacos that were combined
	 */
	
	
	public Saco stackUnite(Saco stack2){
		Saco newSaco = new Saco();
		int[] newStack = new int[this.theStack.length + stack2.theStack.length];
		for(int i=0;i<=this.theStack.length-1;i++) {
			newStack[i] = this.theStack[i];
		}
		for(int k=0;k<=stack2.theStack.length-1;k++){
			newStack[k+this.theStack.length-1] = stack2.theStack[k];
		}
		newSaco.theStack = newStack;
		return newSaco;
	}
	
	
}
