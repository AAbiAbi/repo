import sun.audio.*;//import all the music package
import java.io.*;
public class NBody{
	/**. This class will have NO constructor.
	 *  The goal of this class is to simulate a universe specified in one of the data files.
	 * 
	 */ 
	/**try java NBody 20000000 20000 ./data/suninterference.txt
	 * java NBody 157788000.0 25000.0 data/planets.txt
	 * java NBody 200000000 25000 ./data/3body.txt
	 **/

	public int N;//N represents the number of planets. 
	public  double R;//R  represents the radius of the universe
	public static void main(String[] args) {
		String T_str = args[0];
		String dt_str  = args[1];
		double T = Double.parseDouble(T_str);
		double dt = Double.parseDouble(dt_str);
		String filename = args[2];
		double r = readRadius(filename);
		Body[] planets = readBodies(filename);
		int number_of_Planets = planets.length;

		//for music,
		JFrame frame = new JFrame();
		frame.setSize(200,200);
		JButton button = new JButton("click me");
		frame.add(button);
		button.addActionListener(new AL());
		frame.show(true); 

		/*Read in the bodies and the universe radius from the file described by filename */

		//System.out.println(plantes.length);//5
		/**set the scale so that it matches the radius of the universe. 
		*Then draw the image starfield.jpg as the background. 
		*/
		StdDraw.enableDoubleBuffering();
		/**if you don't call this function,
		* any attempt at smooth animation will look bad and flickery (remove it and see what happens!).
		*/
		StdDraw.setScale(-r, r);//
		StdDraw.clear();
		String background = "./images/starfield.jpg";
		//StdDraw.picture(0,0,background,2r,2r);//the width of the scaled image (in screen coordinates)
		StdDraw.picture(0,0,background);

		for(int q = 0;q <planets.length;q++){
			planets[q].draw();
		}
		StdDraw.show();
		StdDraw.pause(10);
		//show the orign image
		//Then calcutor the forces
		//set up a loop to loop until this time variable reaches (and includes) the T from above.
		double presentTime = 0;
		double[] sounds = StdAudio.read("./audio/2001.mid");
		//StdAudio.play(sounds);

		//loop start
		while(presentTime < T){

			
			Double[] xForces = new Double[number_of_Planets];
			Double[] yForces = new Double[number_of_Planets];
			/**After calculating the net forces for every Body, 
			 * call update on each of the Bodys. This will update each body's position, velocity, and acceleration.*/
			for(int w = 0;w <number_of_Planets;w++){
				xForces[w] = planets[w].calcNetForceExertedByX(planets);
				yForces[w] = planets[w].calcNetForceExertedByY(planets);
				
			}

			for(int e = 0;e < number_of_Planets; e++){
				planets[e].update(dt,xForces[e],yForces[e]);//update body there by dt
			}

			StdDraw.picture(0,0,background);
			for(int u = 0;u <planets.length;u++){
				planets[u].draw();
			}
			
			/*while(!StdDraw.isMousePressed()){

			}*/

			StdDraw.show();
			StdDraw.pause(10);
			presentTime = presentTime + dt;
			

			/**After calculating the net forces for every Body, 
			 * call update on each of the Bodys. This will update each body's position, velocity, and acceleration.*/
			 //for(int e = 0;e < number_of_Planets;e++){
			 	//planets[e]=planets[e].update(dt,)
			 //}

		}//loop end
		


		//StdDraw.show();
		/**Only when you call show() does your drawing get copied from the offscreen canvas
		* to the onscreen canvas, where it is displayed in the standard drawing window.
		* */
		StdDraw.pause(2000);

	}
	/**backgroung music
 	*/
 	public static class AL implements ActionListener{
 		public final void actionPerformed(ActionEvent e){
 			music();
 		}
 	}
 	public static void music(){
 		AudioPlayer musicPlayer = AudioPlayer.player;
 		AudioStream BGM;
 		AudioData musicData;
 		ContinuousAudioDataStream loop = null;
 		try{
 			BGM = new AudioStream(new FileInputStream("./audio/2001.mid"));
 			musicData = BGM.getData;
 			loop = new ContinuousAudioDataStream(musicData);
 		}catch(IOException error){
 			musicPlayer.start(loop);
 		}
 	}

	public static double readRadius(String fileName){
		/**Got the present r from file.*/

		In in = new In(fileName);
		while (!in.isEmpty()) {
			int planets_number = in.readInt();
			double radius = in.readDouble();
			return radius;
		}
		return 0;
	}
	public static Body[] readBodies(String fileName){
		In in = new In(fileName);
		int planets_number = in.readInt();//how many rows(plantes) here
		double radius = in.readDouble();
		//int i = 0;
		Body[] planets_name=new Body[planets_number];
		for(int i = 0;i < planets_number;i++){
			double xPos = in.readDouble();
			double yPos = in.readDouble();
			double xVel = in.readDouble();
			double yVel = in.readDouble();
			double mass = in.readDouble();
			String planet_name = in.readString();
			//String str = plante_name.substring(0, plante_name.indexOf("."));
			//System.out.println(str);
			planets_name[i] = new Body(xPos,yPos,xVel,yVel,mass,planet_name);


		}
		
		return planets_name;

	}
}