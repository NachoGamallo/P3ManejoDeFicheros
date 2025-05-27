package org.example;

import java.io.*;

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
            e.printStackTrace();

        }

        try {

            DataInputStream read = new DataInputStream(new FileInputStream("src/main/resources/binary.bin"));
            boolean boolean_value = read.readBoolean();
            double double_value = read.readDouble();
            int int_value = read.readInt();
            String string_value = read.readUTF();

            System.out.println(boolean_value + " " + double_value + " " + int_value + " " + string_value);
            read.close();

        } catch (IOException e) {

            System.out.println("Algo salio mal");
            e.printStackTrace();

        }

        try {

            FileInputStream mysterious_file = new FileInputStream("src/main/resources/binary.bin");
            int byteToProcess;

            while ((byteToProcess = mysterious_file.read()) != -1){

                System.out.print((char) byteToProcess);

            }
            mysterious_file.close();

        } catch (IOException e) {

            System.out.println("Algo salio mal");
            e.printStackTrace();

        }


    }

}
