/*
 * Copyright [2011-2016] "Neo Technology"
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 *
 */
package cn.edu.bupt.yaoxintong.domain;

import org.neo4j.ogm.annotation.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@JsonIdentityInfo(generator = JSOGGenerator.class)
@NodeEntity
public class Medicine {

    @Id
	@GeneratedValue
	private Long id;
	
	private String rId;
	/**
	 * '产品名称':'name'
	 */
	private String name;

	/**
	 * '剂型':'dosageForm',
	 */
	@Relationship(type = "剂型是", direction = Relationship.OUTGOING)
	private DosageForm dosageForm;

	/**
	 * '生产单位':'productionUnit',
	 */
	@Relationship(type = "生产厂家是", direction = Relationship.OUTGOING)
	private Company productionUnit;

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getProductionUnit() {
		return productionUnit;
	}

	public void setProductionUnit(Company productionUnit) {
		this.productionUnit = productionUnit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DosageForm getDosageForm() {
		return dosageForm;
	}

	public void setDosageForm(DosageForm dosageForm) {
		this.dosageForm = dosageForm;
	}

	public void updateFrom(Medicine update) {
		// TODO Auto-generated method stub
	}

	public String getrId() {
		return rId;
	}

	public void setrId(String rId) {
		this.rId = rId;
	}
}
