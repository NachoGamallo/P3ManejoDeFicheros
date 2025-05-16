package org.example;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Binario {

    public static void main(String[] args) {

        try {

            DataOutputStream binary_file = new DataOutputStream(new FileOutputStream("src/main/resources/binary.bin"));
            binary_file.writeBoolean(true);
            binary_file.writeDouble(3.141516);
            binary_file.writeInt(10);
            binary_file.writeUTF("Hola");

        } catch (IOException e) {

            System.out.println("Hubo un problema");

        }
    }
}
