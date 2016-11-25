package boot.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="term_synonym")
public class TermSynonym implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="term_synonym")
	private String termSynonym;
	@Column(name="acc_synonym")
	private String accSynonym;
	@Column (name="synonym_type_id") 
	private int synonymTypeId;
	@Column (name="synonym_category_id")
	private int synonymCategoryId;
	
	
	public TermSynonym(String termSynonym, String accSynonym, int synonymTypeId, int synonymCategoryId) {
		super();
		this.termSynonym = termSynonym;
		this.accSynonym = accSynonym;
		this.synonymTypeId = synonymTypeId;
		this.synonymCategoryId=synonymCategoryId;
		
	}
	
	public TermSynonym() {
		this("","", 0,0);
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTermSynonym() {
		return termSynonym;
	}

	public void setTermSynonym(String termSynonym) {
		this.termSynonym = termSynonym;
	}

	public String getAccSynonym() {
		return accSynonym;
	}

	public void setAccSynonym(String accSynonym) {
		this.accSynonym = accSynonym;
	}

	public int getSynonymTypeId() {
		return synonymTypeId;
	}

	public void setSynonymTypeId(int synonymTypeId) {
		this.synonymTypeId = synonymTypeId;
	}

	public int getSynonymCategoryId() {
		return synonymCategoryId;
	}

	public void setSynonymCategoryId(int synonymCategoryId) {
		this.synonymCategoryId = synonymCategoryId;
	}

	@Override
	public String toString() {
		return "TermSynonym [id=" + id + ", termSynonym=" + termSynonym + ", accSynonym=" + accSynonym + ", synonymTypeId=" + synonymTypeId
				+ ", synonymCategoryId=" + synonymCategoryId + "]";
	}

	
	
}
