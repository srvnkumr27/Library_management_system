package util;

import java.io.*;

public class DataManager {
    public static void save(Object obj, String filename) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(obj);
            out.close();
        } catch (Exception e) {
            System.out.println("Error Saving Data");
        }
    }

    public static Object load(String filename) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            Object obj = in.readObject();
            in.close();
            return obj;
        } catch (Exception e) {
            return null;
        }
    }
}
