package kp.company.domain;

/**
 * The company.
 *
 */
public class Company {

	private long id;

	private String name;

	/**
	 * Constructor.
	 * 
	 */
	public Company() {
		super();
	}

	/**
	 * Constructor with parameters.
	 * 
	 * @param id   the company id
	 * @param name the company name
	 */
	public Company(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * Gets the company id.
	 * 
	 * @return the id
	 */
	public long getId() {

		return id;
	}

	/**
	 * Sets the company id.
	 * 
	 * @param id the id
	 */
	public void setId(long id) {

		this.id = id;
	}

	/**
	 * Gets the company name.
	 * 
	 * @return the company name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the company name.
	 * 
	 * @param name the company name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
