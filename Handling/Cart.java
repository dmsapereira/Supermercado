package Handling;

public interface Cart {
    public String getName();

    public int getVolume();

    public void addItem(String itemName, int itemCost, int volume);

    public int getVolumeLeft();
}
