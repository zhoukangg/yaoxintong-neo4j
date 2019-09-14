package cn.edu.bupt.yaoxintong.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@NodeEntity
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Company {
	@Id
	@GeneratedValue
	private Long id;
	/**
	 *  '产品名称':'name'
	 */
	
	private String name;
	private String rId;
	public String getrId() {
		return rId;
	}
	public void setrId(String rId) {
		this.rId = rId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
