public class BodyTest{
	 public static void main(String[] args) {
	 	testBodyConstructor();
	 	checkCalcDistanceandForce();
	 	//Samh.xxPos = 1;
	 	//Samh.yyPos = 0;
	 	//Samh.mass = 10;
	 	Body Aegir = new Body(3,5,0,0,5,"segir");
	 	Body Rocinante = new Body(5,-3,0,0,50,"rocinante");
	 	//System.out.println(Samh.calcDistance(Rocinante));
	 	//System.out.println(Samh.calcForceExertedBy(Rocinante));
	 	//System.out.println(Samh.calcForceExertedByX(Rocinante));
	 	//Body[] allBodys = {Samh, Rocinante, Aegir};
		
		//Samh.calcNetForceExertedByY(allBodys);
		//System.out.println(Samh.calcNetForceExertedByX(allBodys));
	 }
	 //test the Body method
	 public static void testBodyConstructor(){
	 	System.out.println("Checking the first Body Constructor.");
	 	Body Samh = new Body(1,0,0,0,10,"samh");
	 	
	 	checkParametersEqual(Samh.xxPos,1,"xxPos");
	 	checkParametersEqual(Samh.yyPos,0,"yyPos");
	 	checkParametersEqual(Samh.xxVel,0,"xxVel");
	 	checkParametersEqual(Samh.yyVel,0,"yyVel");
	 	checkParametersEqual(Samh.mass,10,"mass");
	 	if(Samh.imgFileName.equals("samh")){
	 		System.out.println("Pass-imgFileName-Expected to be samh, and you give "+Samh.imgFileName);
	 	}else{
	 		System.out.println("False!! imgFileName-Expected to be samh, but you give "+Samh.imgFileName);
	 	}
		//first constructor finished.
	 	//then we test the second constructor
	 	System.out.println("Checking the second Body Constructor");
	 	Body Aegir = new Body(Samh);
	 	//if(Aegir.equals(Samh)){
	 		//System.out.println("Pass-imgFileName-Expected to be samh, and you give "+Samh.imgFileName);
	 	//}else{
	 		//System.out.println("False-imgFileName-Expected to be samh, but you give "+Samh.imgFileName);
	 	//}
	 	checkParametersEqual(Samh.xxPos,Aegir.xxPos,"xxPos");
	 	checkParametersEqual(Samh.yyPos,Aegir.yyPos,"yyPos");
	 	checkParametersEqual(Samh.xxVel,Aegir.xxVel,"xxVel");
	 	checkParametersEqual(Samh.yyVel,Aegir.yyVel,"yyVel");
	 	checkParametersEqual(Samh.mass,Aegir.mass,"mass");
	 	if(Samh.imgFileName.equals(Aegir.imgFileName)){
	 		System.out.println("Pass-imgFileName-Expected to be "+Samh.imgFileName+", and you give "+Aegir.imgFileName);
	 	}else{
	 		System.out.println("False!! imgFileName-Expected to be "+Samh.imgFileName+", but you give "+Aegir.imgFileName);
	 	}


	 }
	 // panduanfangfa
	 public static void checkParametersEqual(double actual,double expected , String label){
	 	if(Double.isNaN(actual)||Double.isInfinite(actual)){
	 		System.out.println("False!! "+label+"-Expected to be "+expected+", but you give"+actual);
	 		throw new IllegalArgumentException();
	 	}else if(actual == expected){
	 		System.out.println("Pass-"+label+"-Expected to be "+expected+", and you give"+actual);
	 		//return true;
	 	}else{
	 		System.out.println("False!! "+label+"-Expected to be "+expected+", but you give"+actual);
	 		//return false;
	 	}

	 }
	 //check the calcdistance method
	 /**
     *  Checks whether or not two Doubles are equal and prints the result.
     *
     *  @param  expected    Expected double
     *  @param  actual      Double received
     *  @param  label       Label for the 'test' case
     *  @param  eps         Tolerance for the double comparison.
     */
     public static void checkCalcDistanceandForce(){
     	System.out.println("Checking calcDistance");

        Body b1 = new Body(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Body b2 = new Body(2.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Body b3 = new Body(4.0, 5.0, 3.0, 4.0, 5.0, "jupiter.gif");
        boolean i = tolerantCalc(b1.calcDistance(b2),1.0,0.01);
        boolean j = tolerantCalc(b1.calcDistance(b3),5.0,0.01);
        if(i == true && j == true){
        	System.out.println("Pass-calcDistance().All testing-numbers are within the limit.");
        }else{
        	System.out.println("False!! calcDistance() are beyound the limit or null or infinite.");
        	throw new IllegalArgumentException();
        }
        System.out.println("Checking calcForceExertedTotally");
        boolean k = tolerantCalc(b1.calcForceExertedBy(b3), 6.67e-11,  1.0e-12);
        if(k == true){
        	System.out.println("Pass-calcForceExertedBy().All testing-numbers are within the limit.");
        }else{
        	System.out.println("False!! calcForceExertedBy() are beyound the limit or null or infinite.");
        	throw new IllegalArgumentException();
        }
        //check the force exerted by x or y then
        System.out.println("Checking the calcForceExertedByX and Y.");
        boolean u = tolerantCalc(b1.calcForceExertedByX(b3), 4.002e-11, 1.0e-12);//, "calcForceExertedByX()"
        boolean l = tolerantCalc(b1.calcForceExertedByY(b3), 5.336e-11, 1.0e-12);//, "calcForceExertedByY()"
        if(u == true && l == true){
        	System.out.println("Pass-calcForceExertedByX and Y.All testing-numbers are within the limit.");
        }else{
        	System.out.println("False!! calcForceExertedByX and Y are beyound the limit or null or infinite.");
        	throw new IllegalArgumentException();
        }
        /** actually i am considering making a nested design.if and if and if ... then return a boolean value.
        *use the boolean to get the finial result
        */
        //check the net force on x or y
        System.out.println("");

     }
     //set a tolerant method,due to the computing error.there must exists a permission limit.
     public static boolean tolerantCalc(double actual,double expected,double tolerance){
     	if(Double.isNaN(actual)||Double.isInfinite(actual)){
     		//System.out.println("False!! calcDistance() expected to be "+expected+",but you give "+actual);
     		throw new IllegalArgumentException();// pao chu yi chang zhi
     		//return false;//when throw, we dont return anything.because the abnormal value has been throw
     	}else if(Math.abs(actual - expected)<=tolerance*Math.max(actual,expected)){
     		return true;

     	}else{
     		return false;
     	}
     }
     //test calc force exerted totally
     /*public static void testCalcForceExertedBy(){
     	System.out.println("Checking calcForceExertedBy...");

     }*/

}