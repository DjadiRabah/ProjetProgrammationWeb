package model.pojo;

public class Item 
{
	private int id;
	private String name;
	private int hp;
	private int attack;
	private int defense;
	private double dodge;
	
	
	
	/**
	 * 
	 */
	public Item() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param hp
	 * @param attack
	 * @param defense
	 * @param dodge
	 */
	public Item(int id, String name, int hp, int attack, int defense, double dodge) {
		super();
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.dodge = dodge;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the hpItem
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * @return the dodge
	 */
	public double getDodge() {
		return dodge;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param hpItem the hpItem to set
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}

	/**
	 * @param defense the defense to set
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}

	/**
	 * @param dodge the dodge to set
	 */
	public void setDodge(double dodge) {
		this.dodge = dodge;
	}

	@Override
	public String toString() 
	{
		return name + "\nHP : " + hp + "\nAttack : " + attack
				+ "\nDefense : " + defense + "\nDodge : " + dodge;
	}
}
