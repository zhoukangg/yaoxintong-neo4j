package cn.edu.bupt.yaoxintong.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.edu.bupt.yaoxintong.pojo.Medicine;

public interface MedicineMapper extends JpaRepository<Medicine, String> {
	List<Medicine> findByDrugNameLike(String name);

	List<Medicine> findByManufacturerLike(String name);

	List<Medicine> findByUseForIllnessLike(String name);

	List<Medicine> findByBrandLike(String string);

}