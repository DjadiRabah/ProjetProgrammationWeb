package model.pojo;

public class Character 
{
	private int id;
	private String name;
	private String lore;
	private int hpMax;
	private int attack;
	private int defense;
	private double dodge;

	/**
	 * @param id
	 * @param name
	 * @param lore
	 * @param hpMax
	 * @param attack
	 * @param defense
	 * @param dodge
	 */
	public Character(int id, String name, String lore, int hpMax, int attack, int defense, double dodge) {
		super();
		this.id = id;
		this.name = name;
		this.lore = lore;
		this.hpMax = hpMax;
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
	 * @return the lore
	 */
	public String getLore() {
		return lore;
	}

	/**
	 * @return the hpMax
	 */
	public int getHpMax() {
		return hpMax;
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
	 * @param name the name to set
	 */
	public void setLore(String lore) {
		this.lore = lore;
	}

	/**
	 * @param hpMax the hpMax to set
	 */
	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
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
		return name + "\n" + lore + "\nHP : " + hpMax + "\nAttack : " + attack + "\nDefense : " + defense + "\nDodge : " + dodge;
	}
}
