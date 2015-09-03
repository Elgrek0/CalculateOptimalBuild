/*
 * This software is ment to be used only by skilled players.
 * It wont work for noobs, such as these who main Karma or so.
 */
package get.rekt.noob.storage;

import constant.Region;
import dto.Static.ChampionList;
import dto.Static.ItemList;
import dto.Static.MasteryList;
import dto.Static.RuneList;
import static java.lang.System.out;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.java.riotapi.RiotApi;
import main.java.riotapi.RiotApiException;

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
    private boolean _deserializedAllData = false;

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

    public boolean isRunning() {
        return thread.isAlive();
    }

    public void Start(DataManagementMode managementMode) throws Exception {
        if (isRunning()) {
            throw new Exception("Data center has already been started.");
        }
        tasks.add(new DataTask() {

            @Override
            public void run() {
                try {
                    System.out.println("loading champion list");
                    _championList = DataLoader.Load("ChampionList.lel");
                    System.out.println("loading mastery list");
                    _masteryList = DataLoader.Load("MasteryList.lel");
                    System.out.println("loading rune list");
                    _runeList = DataLoader.Load("RuneList.lel");
                    System.out.println("loading item list");
                    _itemList = DataLoader.Load("ItemList.lel");
                    System.out.println("finished loading local data");
                    _isLoaded = true;
                    _deserializedAllData = true;
                } catch (Exception e) {
                    System.out.println("failed to load local data");
                    _deserializedAllData = false;
                }
            }

        });

        if ((managementMode.getValue() & DataManagementMode.DOWNLOAD.getValue()) == 1) {
            if (!_deserializedAllData) {
                tasks.add(new DataTask() {

                    @Override
                    public void run() {
                        try {
                            RiotApi api = new RiotApi("2a555fa2-16f8-4597-9502-77e35df6faf4");
                            System.out.println("downloading champion list");
                            _championList = api.getDataChampionList();
                            System.out.println("downloading mastery list");
                            _masteryList = api.getDataMasteryList();
                            System.out.println("downloading rune list");
                            _runeList = api.getDataRuneList();
                            System.out.println("downloading item list");
                            _itemList = api.getDataItemList();
                            System.out.println("downloading complete");
                        } catch (RiotApiException ex) {
                            Logger.getLogger(DataCenter.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        tasks.add(new DataTask() {

                            @Override
                            public void run() {
                                System.out.println("saving champion list");
                                DataLoader.Save(_championList, "ChampionList.lel");
                                System.out.println("saving mastery list");
                                DataLoader.Save(_masteryList, "MasteryList.lel");
                                System.out.println("saving rune list");
                                DataLoader.Save(_runeList, "RuneList.lel");
                                System.out.println("saving item list");
                                DataLoader.Save(_itemList, "ItemList.lel");
                            }
                        });
                    }
                });
            }
        }
        thread.start();
        if (tasks.isEmpty()) {
            throw new Exception("Task list is empty, make sure your data management mode is alright.");
        }
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
