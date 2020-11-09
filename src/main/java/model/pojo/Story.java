package model.pojo;

public class Story 
{
	private int id;
	private String name;
	private String synopsis;
	
	/**
	 * 
	 */
	public Story() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param synopsis
	 */
	public Story(int id, String name, String synopsis) {
		super();
		this.id = id;
		this.name = name;
		this.synopsis = synopsis;
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
	 * @return the synopsis
	 */
	public String getSynopsis() {
		return synopsis;
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
	 * @param synopsis the synopsis to set
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
}
