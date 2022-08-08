package br.com.gustavo.ws.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GrupoEntity implements Serializable{

	private static final long serialVersionUID = 8354702217742382344L;
	
	@Id
	@Column(name="IDGRUPO")
	private BigDecimal id;
	
	@Column(name="NMGRUPO")
	private String name;
	
	@Column(name="DSGRUPO")
	private String description;
	
	@Id
	@Column(name="IDSISTEMA")
	private BigDecimal systemId;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getSystemId() {
		return systemId;
	}

	public void setSystemId(BigDecimal systemId) {
		this.systemId = systemId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	

}
