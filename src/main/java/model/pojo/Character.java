package model.pojo;

public class Character implements Pojo
{
	private int id;
	private String name;
	private String lore;
	private String filename;
	private int hp;
	private int attack;
	private int defense;
	private double dodge;
	

	/**
	 * 
	 */
	public Character()
	{
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param lore
	 * @param filename
	 * @param hp
	 * @param attack
	 * @param defense
	 * @param dodge
	 */
	public Character(int id, String name, String lore, String filename, int hp, int attack, int defense,
			double dodge) {
		super();
		this.id = id;
		this.name = name;
		this.lore = lore;
		this.filename = filename;
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
	 * @return the lore
	 */
	public String getLore() {
		return lore;
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @return the hp
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
	 * @param lore the lore to set
	 */
	public void setLore(String lore) {
		this.lore = lore;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * @param hpMax the hpMax to set
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
		return name + "\n" + lore + "\nHP : " + hp + "\nAttack : " + attack + "\nDefense : " + defense + "\nDodge : " + dodge;
	}
}
