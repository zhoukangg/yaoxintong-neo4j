package cn.edu.bupt.yaoxintong;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.bupt.yaoxintong.dao.MedicineCompanyMapper;
import cn.edu.bupt.yaoxintong.dao.MedicineMapper;
import cn.edu.bupt.yaoxintong.domain.Company;
import cn.edu.bupt.yaoxintong.domain.DosageForm;
import cn.edu.bupt.yaoxintong.pojo.Medicine;
import cn.edu.bupt.yaoxintong.pojo.MedicineCompany;
import cn.edu.bupt.yaoxintong.repository.CompanyRepository;
import cn.edu.bupt.yaoxintong.repository.DosageFormRepository;
import cn.edu.bupt.yaoxintong.repository.MedicineRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class YaoxintongNeo4jApplicationTests {

	@Autowired
	private MedicineMapper medicineDao;
	@Autowired
	private MedicineCompanyMapper companyDao;
	@Autowired
	private MedicineRepository medicineRepository;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private DosageFormRepository dosageFormRepository;

	@Test
	public void ex_R_medicnie() {

		List<Medicine> findAll = medicineDao.findAll();

		for (Medicine m : findAll) {
			cn.edu.bupt.yaoxintong.domain.Medicine medicine = new cn.edu.bupt.yaoxintong.domain.Medicine();
			medicine.setName(m.getDrugName());
			medicine.setrId(m.getId());
			
			Company productionUnit = null;
			if(companyRepository.findByName(m.getManufacturer())==null) {
				productionUnit = new Company() ;
				productionUnit.setName(m.getManufacturer());
				List<MedicineCompany> findByCompanyName = companyDao.findByCompanyName(m.getManufacturer());
				if(!findByCompanyName.isEmpty()) {
					productionUnit.setrId(findByCompanyName.get(0).getId());
				}
				
			}else {
				productionUnit = companyRepository.findByName(m.getManufacturer());
			}
			medicine.setProductionUnit(productionUnit);

			
			DosageForm dosageForm = null;
			if(dosageFormRepository.findByName(m.getDrugForm())==null) {
				dosageForm = new DosageForm() ;
				dosageForm.setName(m.getDrugForm());
			}else {
				dosageForm = dosageFormRepository.findByName(m.getDrugForm());
			}
			medicine.setDosageForm(dosageForm);
			
			medicineRepository.save(medicine);
		}
	}

}
