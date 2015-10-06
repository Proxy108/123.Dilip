package com.techNarayana.ejobzz.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jobseeker_apply_job")
public class JobApplyDomain  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="key")
	private Integer key;
	
	@Column(name="jid")
	private Integer jId;
	
	@Column(name="jsid")
	private Integer jsId;
	
	
	@Column(name="creates")
	private Date creates;

	
	
	public Date getCreates() {
		return creates;
	}

	public void setCreates(Date creates) {
		this.creates = creates;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public Integer getjId() {
		return jId;
	}

	public void setjId(Integer jId) {
		this.jId = jId;
	}

	public Integer getJsId() {
		return jsId;
	}

	public void setJsId(Integer jsId) {
		this.jsId = jsId;
	}
	
	

}
