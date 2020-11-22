package model.pojo;

public class Screen implements Pojo {
	private int id ;
	private String name;
	private String message;
	private int idCharacter;
	private int idChest;
	private int idScreen1;
	private int idScreen2;
	private int idScreen3;
	private String action1;
	private String action2;
	private String action3;
	private String backGround;
	public Screen() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @param id
	 * @param name
	 * @param message
	 * @param idCharacter
	 * @param idChest
	 * @param idScreen1
	 * @param idScreen2
	 * @param idScreen3
	 * @param action1
	 * @param action2
	 * @param action3
	 * @param backGround
	 */
	public Screen(int id, String name, String message, int idCharacter, int idChest, int idScreen1, int idScreen2,
			int idScreen3, String action1, String action2, String action3, String backGround) {
		super();
		this.id = id;
		this.name = name;
		this.message = message;
		this.idCharacter = idCharacter;
		this.idChest = idChest;
		this.idScreen1 = idScreen1;
		this.idScreen2 = idScreen2;
		this.idScreen3 = idScreen3;
		this.action1 = action1;
		this.action2 = action2;
		this.action3 = action3;
		this.backGround = backGround;
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the idCharacter
	 */
	public int getIdCharacter() {
		return idCharacter;
	}

	/**
	 * @param idCharacter the idCharacter to set
	 */
	public void setIdCharacter(int idCharacter) {
		this.idCharacter = idCharacter;
	}

	/**
	 * @return the idChest
	 */
	public int getIdChest() {
		return idChest;
	}

	/**
	 * @param idChest the idChest to set
	 */
	public void setIdChest(int idChest) {
		this.idChest = idChest;
	}

	/**
	 * @return the idScreen1
	 */
	public int getIdScreen1() {
		return idScreen1;
	}

	/**
	 * @param idScreen1 the idScreen1 to set
	 */
	public void setIdScreen1(int idScreen1) {
		this.idScreen1 = idScreen1;
	}

	/**
	 * @return the idScreen2
	 */
	public int getIdScreen2() {
		return idScreen2;
	}

	/**
	 * @param idScreen2 the idScreen2 to set
	 */
	public void setIdScreen2(int idScreen2) {
		this.idScreen2 = idScreen2;
	}

	/**
	 * @return the idScreen3
	 */
	public int getIdScreen3() {
		return idScreen3;
	}

	/**
	 * @param idScreen3 the idScreen3 to set
	 */
	public void setIdScreen3(int idScreen3) {
		this.idScreen3 = idScreen3;
	}

	/**
	 * @return the action1
	 */
	public String getAction1() {
		return action1;
	}

	/**
	 * @param action1 the action1 to set
	 */
	public void setAction1(String action1) {
		this.action1 = action1;
	}

	/**
	 * @return the action2
	 */
	public String getAction2() {
		return action2;
	}

	/**
	 * @param action2 the action2 to set
	 */
	public void setAction2(String action2) {
		this.action2 = action2;
	}

	/**
	 * @return the action3
	 */
	public String getAction3() {
		return action3;
	}

	/**
	 * @param action3 the action3 to set
	 */
	public void setAction3(String action3) {
		this.action3 = action3;
	}

	/**
	 * @return the backGround
	 */
	public String getBackGround() {
		return backGround;
	}

	/**
	 * @param backGround the backGround to set
	 */
	public void setBackGround(String backGround) {
		this.backGround = backGround;
	}

	@Override
	public String toString() {
		return "Screen [id=" + id + ", name=" + name + ", message=" + message + ", idCharacter=" + idCharacter
				+ ", idChest=" + idChest + ", idScreen1=" + idScreen1 + ", idScreen2=" + idScreen2 + ", idScreen3="
				+ idScreen3 + ", action1=" + action1 + ", action2=" + action2 + ", action3=" + action3 + ", backGround="
				+ backGround + "]";
	}

	
	
	
	
}
