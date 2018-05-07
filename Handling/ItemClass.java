package Handling;

public class ItemClass implements Item {
	private String name;
	private int cost,volume;
	
	public ItemClass(String name,int cost,int volume) {
		this.name=name;
		this.cost=cost;
		this.volume=volume;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getVolume() {
		return this.volume;
	}

	@Override
	public int getCost() {
		return this.cost;
	}

	
}
