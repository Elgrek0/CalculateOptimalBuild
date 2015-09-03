/*
 * This software is ment to be used only by skilled players.
 * It wont work for noobs, such as these who main Karma or so.
 */
package get.rekt.noob.storage;

import dto.Champion.ChampionList;
import dto.Static.ItemList;
import dto.Static.MasteryList;
import dto.Static.RuneList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robert
 */
public class DataCenter {

    /**
     * Singleton pattern
     */
    private static DataCenter _instance;

    /**
     * Singleton getter
     *
     * @return the singleton instance
     */
    public static DataCenter getInstance() {
        if (_instance == null) {
            _instance = new DataCenter();
        }
        return _instance;
    }

    private Thread thread;
    private LinkedList<DataTask> tasks = new LinkedList<DataTask>();

    private boolean _isLoaded = false;

    private RuneList _runeList;
    private ChampionList _championList;
    private ItemList _itemList;
    private MasteryList _masteryList;

    public ChampionList getChampionList() throws Exception {
        if (!_isLoaded) {
            throw new Exception("Data center is not loaded yet.");
        }
        return _championList;
    }

    public ItemList getItemList() throws Exception {
        if (!_isLoaded) {
            throw new Exception("Data center is not loaded yet.");
        }
        return _itemList;
    }

    public MasteryList getMasteryList() throws Exception {
        if (!_isLoaded) {
            throw new Exception("Data center is not loaded yet.");
        }
        return _masteryList;
    }

    public RuneList getRuneList() throws Exception {
        if (!_isLoaded) {
            throw new Exception("Data center is not loaded yet.");
        }
        return _runeList;
    }

    public boolean isLoaded() {
        return _isLoaded;
    }
    
    public boolean isRunning()
    {
        return thread.isAlive();
    }
    
    public void Start(DataManagementMode managementMode) throws Exception
    {
        if(isRunning())
            throw new Exception("Data center has already been started.");
        
        tasks.add(new DataTask() {

            @Override
            public void run() {
            }
        });
        
    }

    private DataCenter() {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (tasks) {
                        if (tasks.size() >= 1) {
                            tasks.getFirst().run();
                            tasks.removeFirst();
                        }
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(DataCenter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        );
    }
    
}
