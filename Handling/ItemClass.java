package Handling;

public class ItemClass implements Item,Named {
	/**
	 * nome do artigo
	 */
	private String name;
	/**
	 * cost-> custo do artigo
	 * volume-> volume do objeto
	 */
	private int cost,volume;

	/**
	 * Construtor
	 * @param name nome do artigo
	 * @param cost custo do artigo
	 * @param volume volume do artigo
	 */
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
