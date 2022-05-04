//import org.apache.commons.math3.util.FastMath;//fan sanjiao function
import java.math.*;
public class Body{
	/*public static void main(String[] args) {
		
	}
	
	we’ll never run the Body class directly (i.e. we will never run java Body). Also, all methods should be non-static.
	*/
		public double xxPos;// = xP;// Its current x position
		public double yyPos;// = yP;// Its current y position
		public double xxVel;// = xV;//Its current velocity in the x direction
		public double yyVel;// = yV;//Its current velocity in the y direction
		public double mass;// = m;//Its mass
		public String imgFileName;// = img;;//The name of the file that corresponds to the image that depicts the body
		//Path p = Paths.get("F:/Git/Git/recipes/repo/proj0/images/img.gif");
		//String imgFileName = p.getFileName().toString();
		//实例变量，每个实例独立拥有，只能通过实例调用
		public static double G = 6.67e-11;
		/**It is good practice to declare any constants as a static final variable in your class, 
		 *and to use that variable anytime you wish to use the constant.

         *Hint 2: Java supports scientific notation.
         */
		public void draw(){
			/**Add one last method to the Body class, draw, that uses the StdDraw API mentioned above
		 	* to draw the Body’s image at the Body’s position. 
		 	* The draw method should return nothing and take in no parameters.*/
		 	String planetPicName = "./images/"+this.imgFileName;//ti qu picture name
		 	if(this.xxVel==0.0 & this.yyVel==0.0){
		 		double angle = 0;
		 		StdDraw.picture(this.xxPos,this.yyPos,planetPicName,angle);
		 	}else if(this.xxVel ==0.0 & this.yyVel < 0.0){
		 		double angle = -90;
		 		StdDraw.picture(this.xxPos,this.yyPos,planetPicName,angle);
		 	}else if(this.xxVel ==0.0 & this.yyVel > 0.0){
		 		double angle = 90;
		 		StdDraw.picture(this.xxPos,this.yyPos,planetPicName,angle);
		 	}else if(this.xxVel <0.0 & this.yyVel ==0.0){
		 		double angle = 180;
		 		StdDraw.picture(this.xxPos,this.yyPos,planetPicName,angle);
		 	}else if(this.xxVel >0.0 & this.yyVel ==0.0){
		 		double angle = 0;
		 		StdDraw.picture(this.xxPos,this.yyPos,planetPicName,angle);
		 	}else {
		 		//double tan_Angle = this.yyVel/this.xxVel;//calc the tan value by velosity at present;
		 		double rr = Math.atan2(this.yyVel,this.xxVel);

		 		double angle =Math.toDegrees(rr);
		 		StdDraw.picture(this.xxPos,this.yyPos,planetPicName,angle);
		 	}//get the degree*/

		 	//StdDraw.picture(this.xxPos,this.yyPos,planetPicName,angle);


		}
	
	public Body(double xP,double yP,double xV,double yV,double m,String img){
		xxPos = xP;// Its current x position
		yyPos = yP;// Its current y position
		xxVel = xV;//Its current velocity in the x direction
		yyVel = yV;//Its current velocity in the y direction
		mass = m;//Its mass
		imgFileName = img;
	}
	public Body(Body b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;

	}
	public double calcDistance(Body a){
		double dx = this.xxPos - a.xxPos;
		double dy = this.yyPos - a.yyPos;
		double r = Math.sqrt(dx*dx + dy*dy); // there is no built-in operator that does squaring or exponentiation.
		return r;
	}

	public double calcForceExertedBy(Body c){
		/* The calcForceExertedBy method takes in a Body,
		* and returns a double describing the force exerted on this body by the given body
		*/
		double r = this.calcDistance(c);
		if(this.equals(c)){
			double F = 0;
			return F;
		}else{
			double F = G * this.mass * c.mass/(r * r);
			return F;
		}
		
		//return in if condition must have seperate value in each branch.
	}
	public double calcForceExertedByX(Body d){
		if(this.equals(d)){
			double Fx = 0;
			return Fx;
		}else{
			double dx = d.xxPos - this.xxPos;
			double Fx = (this.calcForceExertedBy(d)) * dx /(this.calcDistance(d));
			return Fx;
	}
		
	}
	public double calcForceExertedByY(Body e){
		if(this.equals(e)){
			double fy = 0;
			return fy;
		}else{
			double dy = e.yyPos - this.yyPos;
			double fy = (this.calcForceExertedBy(e)) * dy /(this.calcDistance(e));
			return fy;
		}
		//return fy;
	}
	/*Write methods calcNetForceExertedByX and calcNetForceExertedByY 
	*that each take in an array of Bodys and calculates the net X and net Y force 
	*exerted by all bodies in that array upon the current Body
	*/
	public double calcNetForceExertedByX(Body[] Bodys){
		double Fnx = 0;
		for(int i = 0; i <Bodys.length;i++){
			if(this.equals(Bodys[i])){
				continue;
			}else{
				double fnx = this.calcForceExertedByX(Bodys[i]);
				Fnx = Fnx + fnx;
			}
		}
		return Fnx;
	}
	public double calcNetForceExertedByY(Body[] Bodyss){
		double Fny = 0;
		for(int i = 0; i <Bodyss.length;i++){
			if(this.equals(Bodyss[i])){
				continue;
			}else{
				double fny = this.calcForceExertedByY(Bodyss[i]);
				Fny = Fny + fny;
			}
		}
		return Fny;
	}
	/*method that determines how much the forces exerted on the body will cause that body to accelerate, 
	*and the resulting change in the body’s velocity and position in a small period of time dt.
	*/
	public void update(double dt,double fX,double fY){
		//fX:Net force on X-coordinate
		double anx =fX/this.mass;
		double any =fY/this.mass; 
		this.xxVel = this.xxVel + anx *dt;
		this.yyVel = this.yyVel + any *dt;
		this.xxPos = this.xxPos + this.xxVel * dt;
		this.yyPos = this.yyPos + this.yyVel * dt;

	}


}