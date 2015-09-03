/*
 * This software is ment to be used only by skilled players.
 * It wont work for noobs, such as these who main Karma or so.
 */
package get.rekt.noob.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Robert
 */
class DataLoader {

    public static String DataDirectory = System.getProperty("user.dir") + "/FileData/";

    public static <T extends Serializable> T Load(String fileName) throws Exception {
        T e = null;
            FileInputStream fileIn = new FileInputStream(DataDirectory + fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (T) in.readObject();
            in.close();
            fileIn.close();
        
        return e;
    }

    public static <T extends Serializable> void Save(T e, String fileName) {
        try {
            File file = new File(DataDirectory + fileName);
            new File(file.getParent()).mkdirs();
            if(!file.exists())
                file.createNewFile();
            FileOutputStream fileOut
                    = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
