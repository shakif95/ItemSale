import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.*;

public class beep implements PropertyListener{

	@Override
	public void publish() throws Exception {
		//Toolkit.getDefaultToolkit().beep();
		String soundPath = "D:\\WorkSpace_assignments\\ItemSale2\\resource\\Chord0.wav";
		InputStream in = new FileInputStream(soundPath);
		
		AudioStream audio = new AudioStream(in);
		
		AudioPlayer.player.start(audio);
	}

}
