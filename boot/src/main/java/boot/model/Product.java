package boot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="products")
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=45)
	private String name;
	@Column(length=45)
	private String description;
	@Temporal(TemporalType.DATE)
	@Column(name="date_entry")
	private Date dateEntry;
		private int quantity;
	private boolean status;
	
	public Product(String name, String description, Date dateEntry,int quantity, boolean status) {
		super();
		this.name = name;
		this.description = description;
		this.dateEntry = dateEntry;
		this.quantity=quantity;
		this.status = status;
	}
	
	public Product() {
		this("","", new Date(),0,false);
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateEntry() {
		return dateEntry;
	}
	public void setDateEntry(Date dateEntry) {
		this.dateEntry = dateEntry;
	}
	public boolean isStatus() {
		return status;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", dateEntry=" + dateEntry
				+ ", quantity=" + quantity + ", status=" + status + "]";
	}

	
	
}
