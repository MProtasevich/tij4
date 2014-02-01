package io.ex25;


import static net.mindview.util.Print.print;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;


public class Ex25 {
    // Method to copy file, replace allocate()
    // with allocateDirect(), and rename fileDirect:
    public static File toDirect(File f) throws IOException {
        FileInputStream fis = new FileInputStream(f);
        FileChannel fcIn = fis.getChannel();
        ByteBuffer b = ByteBuffer.allocateDirect((int)f.length());
        fcIn.read(b);
        b.flip();

        Charset cs = Charset.defaultCharset();
        CharBuffer cb = cs.decode(b);
        String cbD1 = cb.toString().replace(".allocate(", ".allocateDirect(");
        String cbD = cbD1.replace(f.getName().split("\\.")[0], f.getName()
                .split("\\.")[0] + "Direct");
        CharBuffer cbNew = CharBuffer.wrap(cbD);
        String ext = (f.getName().split("\\."))[1];
        String outFile = (f.getName().split("\\."))[0] + "Direct." + ext;

        FileOutputStream fos = new FileOutputStream(new File(outFile));
        FileChannel fcOut = fos.getChannel();
        fcOut.write(cs.encode(cbNew));
        // fcIn.transferTo(0, f.length(), fcOut);
        fis.close();
        fcIn.close();
        fos.close();
        fcOut.close();
        return new File(outFile);
    }

    // Methods to test performance
    public static void Tester(String s) {
        try { // Uses reflection to call main methods:
            Class<?> c = Class.forName(s);
            String name = c.getSimpleName();
            print("Testing: " + name);
            Method m = c.getMethod("main", String[].class);
            // To test ChannelCopy.class
            // (otherwise (String)null OK for second argument):
            String[] sa = new String[] { "ChannelCopy.java", "Test.txt" };
            long startRun = System.nanoTime();
            m.invoke(c.newInstance(), (Object)sa);
            long duration = System.nanoTime() - startRun;
            print("\nTime to run " + name + " = " + duration + " nanoseconds");
        } catch(Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public static long allocationTime(int i) {
        long start = System.nanoTime();
        ByteBuffer.allocate(i);
        return System.nanoTime() - start;
    }

    public static long directAllocationTime(int i) {
        long start = System.nanoTime();
        ByteBuffer.allocateDirect(i);
        return System.nanoTime() - start;
    }

    public static void main(final String[] args) throws IOException {
        // allocation time related to statup time:
        print("Time to allocate 1024 bytes = " + allocationTime(1024)
                + " nanoseconds");
        print("Time to allocateDirect 1024 bytes = "
                + directAllocationTime(1024) + " nanoseconds");
        print("Time to allocate 48 bytes = " + allocationTime(48)
                + " nanoseconds");
        print("Time to allocateDirect 48 bytes = " + directAllocationTime(48)
                + " nanoseconds");
        print("Time to allocate 1 byte = " + allocationTime(1) + " nanoseconds");
        print("Time to allocateDirect 1 byte = " + directAllocationTime(1)
                + " nanoseconds");
        
        String packageString = "io.", dirString = "src/io/";
        
        Tester(packageString + "GetChannel");
        toDirect(new File(dirString + "GetChannel.java"));
        // after compiling GetChannelDirect:
        Tester(packageString + "BufferToText");
        toDirect(new File(dirString + "BufferToText.java"));
    }
}