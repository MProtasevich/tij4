package io;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("data.txt");
        // Write a file:
        FileChannel fc = fos.getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();
        fos.close();

        // Add to the end of the file:
        RandomAccessFile raf = new RandomAccessFile("data.txt", "rw");
        fc = raf.getChannel();
        fc.position(fc.size()); // Move to the end
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();
        raf.close();

        // Read the file:
        FileInputStream fis = new FileInputStream("data.txt");
        fc = fis.getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        fc.close();
        fis.close();
        buff.flip();
        while(buff.hasRemaining()) {
            System.out.print((char)buff.get());
        }
    }
}