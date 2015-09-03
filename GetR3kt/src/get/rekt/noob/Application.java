/*
 * This software is ment to be used only by skilled players.
 * It wont work for noobs, such as these who main Karma or so.
 */
package get.rekt.noob;

import get.rekt.noob.storage.DataCenter;
import get.rekt.noob.storage.DataManagementMode;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robert
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        while(!DataCenter.getInstance().isLoaded()) {
            try {
                if(!DataCenter.getInstance().isRunning())
                    DataCenter.getInstance().Start(DataManagementMode.LOAD);
                Thread.sleep(100);
                
            } catch (Exception ex) {
                Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
