/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imagenes;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * La clase PlaySound se encarga de reproducir un sonido en el simulador.
 *
 * @author Juan Campos
 * @author Daniel Espitia
 * @version 26102023
 */
public class PlaySound {
    /**
     * Este método reproduce un sonido a partir de un archivo.
     *
     * @param nameFile El nombre del archivo de sonido a reproducir.
     */
    public static void playSound(String nameFile) {
        File soundFile = new File(nameFile);

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("Archivo no encontrado.");
        }
    }
}
