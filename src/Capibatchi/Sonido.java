package Capibatchi;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sonido {

    private Clip clip;
    private long posicionPausa = 0;

    public Sonido(String filePath) {
        try {
            File archivoMusica = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoMusica);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

    public void reproducirEnHiloNuevo(boolean repetir) {
        if (clip != null) {
            if (clip.isRunning()) {
                clip.stop();
            }

            Runnable runnable = () -> {
                clip.setFramePosition(0);
                if (repetir) {
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                } else {
                    clip.start();
                }
            };

            Thread thread = new Thread(runnable);
            thread.start();
        }
    }

    public void detener() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            posicionPausa = clip.getMicrosecondPosition();
        }
    }

    public void reanudar() {
        if (clip != null && !clip.isRunning()) {
            clip.setMicrosecondPosition(posicionPausa);
            clip.start();
        }
    }

    public void cerrar() {
        if (clip != null) {
            clip.close();
        }
    }
}
