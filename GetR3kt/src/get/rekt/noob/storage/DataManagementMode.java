/*
 * This software is ment to be used only by skilled players.
 * It wont work for noobs, such as these who main Karma or so.
 */
package get.rekt.noob.storage;

/**
 *
 * @author Robert
 */
public enum DataManagementMode {
    DOWNLOAD(Integer.parseInt("0001", 2)),
    LOAD(Integer.parseInt("0010", 2)),
    DOWNLOAD_AND_LOAD(DOWNLOAD.id | LOAD.id);
    
    private final int id;
    DataManagementMode(int id) { this.id = id; }
    public int getValue() { return id; }
}
