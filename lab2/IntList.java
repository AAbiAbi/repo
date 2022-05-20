public class IntList{
	public int first;
	public IntList rest;
   
   public IntList(int r, IntList s){
      first = r;
      rest = s;
      //recursion
   }
   /** Return the size of List using Recursion*/
   public int size(){
   	/*for(int j = 1;l.rest != null;j++){
   		l = l.rest;//direct recursion
   	}*/
   		if(rest != null){
   			
   			return 1+this.rest.size();
  	 	}else {
  	 		return 1;
  	 	}
   }
   /*Return the size of the List using no recursion*/
   public int iterativeSize(){
   		if(rest == null){
   			return 1;
   		}else{
   			int j = 2;
   			IntList l = rest;
   			while(l.rest != null){
   				l = l.rest;
   				j++;
   			}
   			return j;

   		}
	}
   	//
   	public int get(int i){
   		int totalSize = this.size();
   		if(i > totalSize - 1){
   			System.out.println("Array Index Out Of Bounds Exception");
   			return 0;
   		}else{
   			if(i <1){
   				return first;
   			}else{
   				IntList l = this;
   				int w = l.first;
   				for(int q = 0; q < i;q++){
   					l = l.rest;
   					w = l.first;

   				}
   				return w;

   			}
   			//i+1 means the i+1 th recursion.
   			//IntList l = rest;
   			
   		}
    }


	public static void main(String[] args) { 
		IntList L = new IntList( 15, null);
      L = new IntList(10,L);
      L = new IntList(5,L);
      System.out.println(L.size());
      System.out.println(L.iterativeSize());
      System.out.println(L.get(3));

	}
}