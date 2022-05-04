import sun.audio.*;
public class TestAngle{
	public static void main(String[] args) {
		//StdAudio.playInBackground("./audio/2001.mid");

		double[] sounds = StdAudio.read("./audio/2001.mid");
		StdAudio.play(sounds);
		StdAudio.loopInBackground("./audio/2001.mid");
    

        // repeat as long as there are more integers to read in
        //while (!StdIn.isEmpty()) {

            // read in the pitch, where 0 = Concert A (A4)
            //int pitch = StdIn.readInt();

            // read in duration in seconds
           // double duration = StdIn.readDouble();

           

            // play it using standard audio
           // StdAudio.playInBackground("./audio/2001.mid");

        
    

	}

}