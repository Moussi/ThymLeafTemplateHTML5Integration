package com.allegoria.admin.dal.typeacte;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.allegoria.admin.dal.repositories.office.AdresseOfficeRepository;
import com.allegoria.admin.dal.repositories.office.OfficeRepository;
import com.allegoria.admin.dal.repositories.office.RibRepository;
import com.allegoria.admin.dom.office.AdresseOffice;
import com.allegoria.admin.dom.office.Office;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/application-contextDal.xml")
public class OfficeTest {

	@Autowired
	AdresseOfficeRepository repository;
	
	@Test
	public void test() {
		AdresseOffice adresseoffice1 = repository.findOne(new Long(10));
		
	
		repository.delete(adresseoffice1);
	}

}
