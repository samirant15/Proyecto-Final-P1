package onlineMedia;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class MediaPlayer {
	
	private JInternalFrame ourFrame = new JInternalFrame();
	private EmbeddedMediaPlayerComponent ourMediaPlayer;
	private String mediaPath = "";
	
	public MediaPlayer(JInternalFrame frame, String vlcPath, String mediaURL){
		this.ourFrame = frame;
		this.mediaPath = mediaURL;
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), vlcPath);
		ourMediaPlayer = new EmbeddedMediaPlayerComponent();
		ourFrame.setContentPane(ourMediaPlayer);
		ourFrame.setSize(frame.getWidth(), frame.getHeight());
		ourFrame.setVisible(true);
		ourFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void run(){
		ourMediaPlayer.getMediaPlayer().playMedia(mediaPath);
	}
	
}
