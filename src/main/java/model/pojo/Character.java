package model.pojo;

public class Character 
{
	private int id;
	private String name;
	private String lore;
	private String fileName;
	private int hpMax;
	private int attack;
	private int defense;
	private double dodge;

	
	
	public Character(int id, String name, String lore, String fileName, int hpMax, int attack, int defense,
			double dodge) {
		super();
		this.id = id;
		this.name = name;
		this.lore = lore;
		this.fileName = fileName;
		this.hpMax = hpMax;
		this.attack = attack;
		this.defense = defense;
		this.dodge = dodge;
	}
	
	


	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getLore() {
		return lore;
	}




	public void setLore(String lore) {
		this.lore = lore;
	}




	public String getFileName() {
		return fileName;
	}




	public void setFileName(String fileName) {
		this.fileName = fileName;
	}




	public int getHpMax() {
		return hpMax;
	}




	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}




	public int getAttack() {
		return attack;
	}




	public void setAttack(int attack) {
		this.attack = attack;
	}




	public int getDefense() {
		return defense;
	}




	public void setDefense(int defense) {
		this.defense = defense;
	}




	public double getDodge() {
		return dodge;
	}




	public void setDodge(double dodge) {
		this.dodge = dodge;
	}




	@Override
	public String toString() 
	{
		return name + "\n" + lore + "\nHP : " + hpMax + "\nAttack : " + attack + "\nDefense : " + defense + "\nDodge : " + dodge;
	}
}
