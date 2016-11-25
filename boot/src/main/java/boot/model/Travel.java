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

@Entity(name="travels")
public class Travel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=200)
	private String place;
	@Column(length=45)
	private String transport;
	@Temporal(TemporalType.DATE)
	@Column(name="date_registry")
	private Date dateRegistry;
		private int cost;
		@Column(name="date_start")
		
		private String dateStart;
		@Column(name="date_finish")
		
		private String dateFinish;
	private boolean validated;
	
	public Travel(String place, String transport, Date dateRegistry,int cost, String dateStart,String datefinish,boolean validated) {
		super();
		this.place = place;
		this.transport = transport;
		this.dateRegistry = dateRegistry;
		this.cost=cost;
		this.validated = validated;
	}
	
	public Travel() {
		this("","", new Date(),0,"","",false);
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public Date getDateRegistry() {
		return dateRegistry;
	}

	public void setDateRegistry(Date dateRegistry) {
		this.dateRegistry = dateRegistry;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateFinish() {
		return dateFinish;
	}

	public void setDateFinish(String dateFinish) {
		this.dateFinish = dateFinish;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", place=" + place + ", transport=" + transport + ", dateRegistry=" + dateRegistry
				+ ", cost=" + cost + ", dateStart=" + dateStart +", dateFinish=" + dateFinish +", validated=" + validated + "]";
	}

	
	
}
