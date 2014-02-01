//: net/mindview/util/OSExecute.java
package io.ex22;


import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

import net.mindview.util.OSExecuteException;


public class OSExecute {
    public static List<String> command(String command) {
        boolean err = false;
        List<String> list = new LinkedList<String>();
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(
                    process.getInputStream()));
            String s;

            while((s = results.readLine()) != null) {
                list.add(s);
            }

            BufferedReader errors = new BufferedReader(new InputStreamReader(
                    process.getErrorStream()));

            // Report errors and return nonzero value
            // to calling process if there are problems:
            while((s = errors.readLine()) != null) {
                System.err.println(s);
                err = true;
            }
        } catch(Exception e) {
            // Compensate for Windows 2000, which throws an
            // exception for the default command line:
            if(!command.startsWith("CMD /C")) {
                command("CMD /C " + command);
            } else {
                throw new RuntimeException(e);
            }
        }
        if(err) {
            throw new OSExecuteException("Errors executing " + command);
        }
        return list;
    }

    public static void main(String[] args) {
        for(String s : OSExecute.command("javap java.lang.Math")) {
            System.out.println(s);
        }
    }
}