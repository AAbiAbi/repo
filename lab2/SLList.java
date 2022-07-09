/**A SLList is a list of integers, which hides the terrible truth of 
 * the nakedness within.
 */

public class SLList<LochNess>{
	
	//we will have a constructor in SLList,which would be a perfect 
	//clothes for the naked intList.
	private class StuffNode{
		public LochNess item;
		public StuffNode next;
		public StuffNode last;
   
  	 	public StuffNode(LochNess i, StuffNode n, StuffNode m){
      	item = i;
      	next = n;
      	last = m;
      //recursion
   		}

   /** Return the size of List using Recursion*/
  
	}
//the first item(if it exists) is at sentinel.next
	private StuffNode sentinel;//you cannot use the variable outside of the SLList class
	private int size;
	//public StuffNode wise;
	//public StuffNode antiwise;
	//create an empty list
	public SLList(){
		size = 0;
		//sentinel = new StuffNode(-21,null);
		//sentinel = new StuffNode(-21,sentinel,sentinel);
		sentinel = new StuffNode(-21,null,null);//I cannot make an infinite irriateing loop.
		//wise = new StuffNode(-21, wise);
		//antiwise = new StuffNode(-21, antiwise);
	}
	public SLList(LochNess x){
		sentinel = new StuffNode(-21,null,null);
		sentinel.next = new StuffNode(x,sentinel,sentinel);
		//sentinel.last = sentinel.next;
		sentinel.last = new StuffNode(x,sentinel,sentinel);
		//wise = new StuffNode(-21, wise);
		//antiwise = new StuffNode(-21, antiwise);
		//wise.next=new StuffNode(x,wise);
		//antiwise.next=new StuffNode(x,antiwise);
		size = 1;
	}
	/**Note: PLEASE do not mess  with first */
	
	 /** add an integer in the front of the list **/
   	public void addFirst(LochNess x){
      sentinel.next = new StuffNode(x,sentinel.next,sentinel);

      if(sentinel.next.next != null){
      		sentinel.next.next.last = sentinel.next;
  			}else{
  				sentinel = new StuffNode(-21,null,null);
				sentinel.next = new StuffNode(x,sentinel,sentinel);
				//sentinel.last = sentinel.next;
				sentinel.last = new StuffNode(x,sentinel,sentinel);
  		}
      //wise.next = new StuffNode (x , wise.next);

      size ++;

   }
   //Return the first item of the list
   	public LochNess getFirst(){
   		
   		
   		/*try{
   			return sentinel.next.item;
   		}catch(NullPointerException e){
   			System.out.println("this sllist is empty");
   			return -21;

   		}*/
   		if(sentinel.next == null){
   			System.out.print("this sllist is empty");
   			return sentinel.item;
   			
   		}else{
   		return sentinel.next.item;
   	}

   		//return first.item;
   }

   public LochNess getLast(){
   		//return sentinel.last

   		/*StuffNode w = sentinel;
   		while(w.next != null){
   			w = w.next;
   		}
   		return w.item;*/
   		if(sentinel.last == null){
   			System.out.print("this sllist is empty");
   			return sentinel.item;

   		}else{
   			return sentinel.last.item;
   		}
   }
   /**Return the size of the list that starts at StuffNode p*/
   private static int size(StuffNode p){
   		/**if(p.next !=null){
   			return 1+size(p.next);
   		}else{
   			return 1;
   		}*/

   		//StuffNode r =p;
   		int t =0;
   		while(p !=null){
 			p = p.next;
   			t ++;
   		}
   		return t;
   		

   }
   public int size(){
   		/**if(this.first.next != null){
   			return 1+this.first.next.size();
   		}else{
   			return 1;
   		}*/
   		/**if(first.next == null){
   			return 1;
   		}else{
   			int j = 2;
   			StuffNode l = first.next;
   			while(l.next != null){
   				l = l.next;
   				j++;
   			}
   			return j;

   		}*/
   		return size;
   }

   public void addLast(LochNess q){
   		/**if(first.next = null){
   			first.next = new StuffNode(q,null);
   		}else{

   		}*/
   		size++;

   		sentinel.last = new StuffNode(q,sentinel,sentinel.last);
   		if(sentinel.last.last != null){
   			sentinel.last.last.next = sentinel.last;
   		}else{
   			sentinel = new StuffNode(-21,null,null);
			sentinel.next = new StuffNode(q,sentinel,sentinel);
				//sentinel.last = sentinel.next;
			sentinel.last = new StuffNode(q,sentinel,sentinel);
   		}


   		/*StuffNode p = sentinel;
   		
   		while(p.next != null){
   			p = p.next;
   			//move p tp the end of the list

   		}
   		//p.next = new StuffNode(q,null);
   		
		
		//size ++;*/

   }

   public void removelast(){
   		if(sentinel.next == null||sentinel.last == null){
   			System.out.println("CANNOT decrease one.");
   			
   		}else{
   			size = size - 1;
   			/*StuffNode q = sentinel;
   			while(q.next.next != null){
   				q=q.next;
   			}
   			q.next = null;*/
   			sentinel.last = new StuffNode(sentinel.last.last.item,sentinel,sentinel.last.last.next);

   		}

   		
   }

   /**public static void main(String[] args) {
		/**Create a list of one integer, namely:10
		 

		SLList k = new SLList();
		k.addFirst(15);
		k.addFirst(20);
		k.addLast(15);
		k.addLast(10);
		k.addLast(5);
		k.addLast(0);
		k.removelast();
		int sizesll = k.size;

		/**
		StuffNode last = new StuffNode(5,null);
		StuffNode[] StuffNodearray= new StuffNode[sizesll];
   		StuffNodearray[0] = k.first;
   		for(int w = 1; w< sizesll;w++){
   			StuffNodearray[w] = StuffNodearray[w-1].next;
   			System.out.println(StuffNodearray[w].item);
   		}
   		int itemm = StuffNodearray[sizesll - 1].item;
   		StuffNodearray[sizesll -1] = new StuffNode( itemm, last);
   		System.out.println(itemm);
   		System.out.println(StuffNodearray[sizesll - 1].next.item);

		System.out.println(k.getFirst());
		System.out.println(sizesll);
		
		
	}
}*/