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
package cn.edu.bupt.yaoxintong.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.neo4j.ogm.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.bupt.yaoxintong.domain.Medicine;
import cn.edu.bupt.yaoxintong.repository.MedicineRepository;

@RestController
@RequestMapping(value = "/api/medicines")
public class MedicineController {

	private MedicineRepository medicineRepository;

	@Autowired
	public MedicineController(MedicineRepository medicineRepository) {
		this.medicineRepository = medicineRepository;
	}

	@RequestMapping(value = "get", method = RequestMethod.GET)
	public String get(String a,HttpServletResponse response, HttpServletRequest request) {
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");
		return a;
	}

	@RequestMapping(value = "/getResource", method = RequestMethod.GET)
	public Medicine readByRId(String id) {
        System.out.println("-------进入接口getResource---id = "+id);
		Medicine medicine = null;
		try {
			System.out.println(id);
			medicine = medicineRepository.findByRId(id);
			System.out.println(medicine.getName());
		}catch (Exception e){
			e.printStackTrace();
		}
		return medicine;
	}
	
	// 以下为通用方法
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Medicine> readAll() {
		return medicineRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Medicine create(@RequestBody Medicine Medicine) {
		return medicineRepository.save(Medicine);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Medicine read(@PathVariable Long id) {
		return medicineRepository.findById(id).orElseThrow(NotFoundException::new);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		medicineRepository.deleteById(id);
	}

	@Transactional
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Medicine update(@PathVariable Long id, @RequestBody Medicine update) {
		final Medicine existing = medicineRepository.findById(id).orElseThrow(NotFoundException::new);
		existing.updateFrom(update);
		return medicineRepository.save(existing);
	}

}
