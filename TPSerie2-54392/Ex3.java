
public class Ex3 {

	public static long fibAlgorythm(int n) {
		
		return fib(n ,0 ,1 );
	}


	public static long fib(int n, int a, int b ) {
	       if(n==0) {
	    	   return a;
	       }else if(n==1) {
	    	   return b;
	       }else {
	    	   return fib(n-1,b,a+b);
	       }
	    }
	
	
}
