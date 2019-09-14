package cn.edu.bupt.yaoxintong.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.edu.bupt.yaoxintong.pojo.MedicineCompany;

public interface MedicineCompanyMapper extends JpaRepository<MedicineCompany, String> {
	List<MedicineCompany> findByCompanyName(String manufacturer);
}