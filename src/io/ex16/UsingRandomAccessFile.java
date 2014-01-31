package io.ex16;


import java.io.IOException;
import java.io.RandomAccessFile;


public class UsingRandomAccessFile {
    static String file = "r16test.dat";

    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        byte[] bIn = new byte[3];
        rf.read(bIn);

        for(int i = 0; i < bIn.length; i++) {
            System.out.println(bIn[i] + " ");
        }

        // Read next 4 bytes as int:
        System.out.println("\nrf.readInt() = " + rf.readInt());
        System.out.println("rf.read() = " + rf.read());
        System.out.println("rf.readBoolean() = " + rf.readBoolean());
        System.out.println("rf.readByte() = " + rf.readByte());
        System.out.println("rf.read() = " + rf.read()); // ASCII h = 104
        System.out.println("rf.read() = " + rf.read()); // ASCII i = 105
        System.out.println("rf.readChar() = " + rf.readChar());
        System.out.println("rf.readChar() = " + rf.readChar());
        System.out.println("rf.readChar() = " + rf.readChar());
        System.out.println("rf.readDouble() = " + rf.readDouble());
        System.out.println("rf.readFloat() = " + rf.readFloat());
        System.out.println("rf.readInt() = " + rf.readInt());
        System.out.println("rf.readLong() = " + rf.readLong());
        System.out.println("rf.readShort() = " + rf.readShort());
        System.out.println("rf.readUTF() = " + rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        byte[] ba = { 0, 1, 2, 3 };
        // Store first 3 bytes of byte[] ba:
        rf.write(ba, 0, 3);
        // Store all 4 bytes in byte[] ba:
        rf.write(ba);
        rf.write((int)255); // Stores the lower 8 bits of int
        rf.writeBoolean(true);
        rf.writeByte((int)1000000);
        rf.writeBytes((String)"hi");
        rf.writeChar(120);
        rf.writeChars("hi");
        rf.writeDouble(3.14159);
        rf.writeFloat(2.1f);
        rf.writeInt(1057);
        rf.writeLong(123456789L);
        rf.writeShort(123);
        rf.writeUTF("Nice piece of work");
        display();

        rf.close();
    }
}