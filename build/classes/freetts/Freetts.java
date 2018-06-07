package freetts;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.audio.AudioPlayer;

public class Freetts {

    private static final String VOICENAME_kevin = "kevin16";
    private String text; 
    Voice voice;

    public void setText(String text) {
        this.text = text;
    }

    public void speak() {
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(VOICENAME_kevin);
        voice.allocate();
        voice.setRate(130);
        voice.speak(text);
    }
    
    public void cancel() {
        AudioPlayer ap = voice.getAudioPlayer();
        ap.cancel();
    }
}
