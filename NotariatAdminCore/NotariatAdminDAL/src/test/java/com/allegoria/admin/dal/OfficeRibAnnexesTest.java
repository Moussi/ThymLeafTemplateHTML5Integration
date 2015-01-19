package com.allegoria.admin.dal;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.allegoria.admin.dal.repositories.office.OfficeRepository;
import com.allegoria.admin.dal.repositories.office.RibRepository;
import com.allegoria.admin.dom.office.Annexe;
import com.allegoria.admin.dom.office.DocumentFichier;
import com.allegoria.admin.dom.office.Office;
import com.allegoria.admin.dom.office.Rib;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/application-contextDal.xml")
public class OfficeRibAnnexesTest {

	@Autowired
	OfficeRepository repository;
	@Autowired
	RibRepository ribRepository;
	@Test
	public void test() {
		Office office1 = repository.findAll().get(0);
		
//		List<Rib> ribs= ribRepository.findAll();
//		Rib rib6=ribs.get(10);
//		rib6.setOfficeFk(office1);
//		ribRepository.save(rib6);
//		System.out.println("Rib 6 "+rib6);
		office1.getRibCollection().clear();
	
		repository.save(office1);
	}

}
