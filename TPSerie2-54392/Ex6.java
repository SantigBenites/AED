
public class Ex6 {

	
	public static int mybinomial (int n , int k, int[][] mem ) {
		if (( n == 0) || ( k == 0) || ( n == k )) {
		 	 return 1;
		}else {
			if(mem[n-1][k-1]!=0) {
				return mem[n-1][k-1];
			}else {
				mem[n-1][k-1] = mybinomial (n -1 , k ,mem ) + mybinomial (n -1 , k -1, mem);
			}
		}
		return mem[n-1][k-1];
	}
	
	public static long binomialAlgorythm (int n , int k) {
		int[][] mem = new int[n][k];
		
		return mybinomial (n,k,mem);
	}
	

}
