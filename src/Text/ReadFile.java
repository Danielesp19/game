/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Text;

/**
 *
 * @author Usuario
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static int[][] readAndParseFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Contamos las líneas para determinar el tamaño de la matriz
            long lineCount = br.lines().count();

            // Volvemos a abrir el archivo ya que hemos consumido las líneas durante el conteo
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            // Inicializamos la matriz
            int[][] matrix = new int[(int) lineCount][];

            // Leemos cada línea y dividimos los números por espacios
            for (int i = 0; i < lineCount; i++) {
                String line = reader.readLine();
                String[] numbers = line.split("\\s+"); // Utilizamos "\\s+" para dividir por espacios

                // Convertimos los números a enteros y los almacenamos en la matriz
                matrix[i] = new int[numbers.length];
                for (int j = 0; j < numbers.length; j++) {
                    matrix[i][j] = Integer.parseInt(numbers[j]);
                }
            }

            return matrix;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.err.println("Error de formato en el archivo. Asegúrate de que cada línea contiene números separados por espacios.");
            return null;
        }
    }
}