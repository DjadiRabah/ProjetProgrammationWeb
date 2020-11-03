package Pojo;

public class Item 
{
	private int idItem;
	private String nameItem;
	private int hpItem;
	private int attackItem;
	private int defenseItem;
	private int dodgeItem;
	
	/**
	 * @param idItem
	 * @param nameItem
	 * @param hpItem
	 * @param attackItem
	 * @param defenseItem
	 * @param dodgeItem
	 */
	public Item(int idItem, String nameItem, int hpItem, int attackItem, int defenseItem, int dodgeItem) {
		super();
		this.idItem = idItem;
		this.nameItem = nameItem;
		this.hpItem = hpItem;
		this.attackItem = attackItem;
		this.defenseItem = defenseItem;
		this.dodgeItem = dodgeItem;
	}
	
	/**
	 * @return the idItem
	 */
	public int getIdItem() {
		return idItem;
	}
	/**
	 * @return the nameItem
	 */
	public String getNameItem() {
		return nameItem;
	}
	/**
	 * @return the hpItem
	 */
	public int getHpItem() {
		return hpItem;
	}
	/**
	 * @return the attackItem
	 */
	public int getAttackItem() {
		return attackItem;
	}
	/**
	 * @return the defenseItem
	 */
	public int getDefenseItem() {
		return defenseItem;
	}
	/**
	 * @return the dodgeItem
	 */
	public int getDodgeItem() {
		return dodgeItem;
	}
	/**
	 * @param idItem the idItem to set
	 */
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	/**
	 * @param nameItem the nameItem to set
	 */
	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}
	/**
	 * @param hpItem the hpItem to set
	 */
	public void setHpItem(int hpItem) {
		this.hpItem = hpItem;
	}
	/**
	 * @param attackItem the attackItem to set
	 */
	public void setAttackItem(int attackItem) {
		this.attackItem = attackItem;
	}
	/**
	 * @param defenseItem the defenseItem to set
	 */
	public void setDefenseItem(int defenseItem) {
		this.defenseItem = defenseItem;
	}
	/**
	 * @param dodgeItem the dodgeItem to set
	 */
	public void setDodgeItem(int dodgeItem) {
		this.dodgeItem = dodgeItem;
	}

	@Override
	public String toString() 
	{
		return nameItem + "\nHP : " + hpItem + "\nAttack : " + attackItem
				+ "\nDefense : " + defenseItem + "\nDodge : " + dodgeItem;
	}
}
