
public class Ex1 {

	
	/**
	  A)
	 **/
	   
	   LinkedBinaryTree<Integer> LBT1 = new LinkedBinaryTree<Integer>(1);
	   LinkedBinaryTree<Integer> LBT2 = new LinkedBinaryTree<Integer>(2);
	   LinkedBinaryTree<Integer> LBT3 = new LinkedBinaryTree<Integer>(3,LBT1,LBT2);
	   LinkedBinaryTree<Integer> LBT4 = new LinkedBinaryTree<Integer>(5);
	   LinkedBinaryTree<Integer> LBT5 = new LinkedBinaryTree<Integer>(6,null,LBT4);
	   LinkedBinaryTree<Integer> EX1 = new LinkedBinaryTree<Integer>(7,LBT3,LBT5);
	   
	 /**
	 B)
	 **/
	 
	  LinkedBinaryTree<Integer> LBT6 = new LinkedBinaryTree<Integer>(6);
	  LinkedBinaryTree<Integer> LBT7 = new LinkedBinaryTree<Integer>(7);
	  LinkedBinaryTree<Integer> LBT8 = new LinkedBinaryTree<Integer>(8,LBT6,LBT7);
	  LinkedBinaryTree<Integer> LBT9 = new LinkedBinaryTree<Integer>(9);
	  LinkedBinaryTree<Integer> LBT10 = new LinkedBinaryTree<Integer>(10,LBT9,null);
	  LinkedBinaryTree<Integer> LBT11 = new LinkedBinaryTree<Integer>(11,LBT8,LBT10);
	  LinkedBinaryTree<Integer> LBT12 = new LinkedBinaryTree<Integer>(12);
	  LinkedBinaryTree<Integer> LBT13 = new LinkedBinaryTree<Integer>(13);
	  LinkedBinaryTree<Integer> LBT14 = new LinkedBinaryTree<Integer>(14,LBT12,LBT13);
	  LinkedBinaryTree<Integer> EX2 = new LinkedBinaryTree<Integer>(17,LBT11,LBT14);
	 
	 
	 
	 
	 
	 
	 /**
	 C)		
	 **/
	  	LinkedBinaryTree<Integer> LBT15 = new LinkedBinaryTree<Integer>(6);
	  	LinkedBinaryTree<Integer> LBT16 = new LinkedBinaryTree<Integer>(7,LBT15,null);
	  	LinkedBinaryTree<Integer> LBT17 = new LinkedBinaryTree<Integer>(7,LBT16,null);
	  	LinkedBinaryTree<Integer> LBT18 = new LinkedBinaryTree<Integer>(7,LBT17,null);
	  	LinkedBinaryTree<Integer> LBT19 = new LinkedBinaryTree<Integer>(7,LBT18,null);
	  	LinkedBinaryTree<Integer> LBT20 = new LinkedBinaryTree<Integer>(7,LBT19,null);
	  	LinkedBinaryTree<Integer> LBT21 = new LinkedBinaryTree<Integer>(7,LBT20,null);
	  	LinkedBinaryTree<Integer> LBT22 = new LinkedBinaryTree<Integer>(7,LBT21,null);
	  	LinkedBinaryTree<Integer> LBT23 = new LinkedBinaryTree<Integer>(7,LBT22,null);
	  	LinkedBinaryTree<Integer> LBT24 = new LinkedBinaryTree<Integer>(7,LBT23,null);
	 		
	 		
	 		
}
