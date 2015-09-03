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
    DOWNLOAD(1),
    LOAD(2);
    
    private final int id;
    DataManagementMode(int id) { this.id = id; }
    public int getValue() { return id; }
}
