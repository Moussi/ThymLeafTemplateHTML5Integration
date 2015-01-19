package com.allegoria.admin.dal.typecomparutioncourrier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.allegoria.admin.dal.repositories.office.OfficeRepository;
import com.allegoria.admin.dal.repositories.office.RibRepository;
import com.allegoria.admin.dal.repositories.typeacte.TypeSousProduitRepository;
import com.allegoria.admin.dom.office.Office;
import com.allegoria.admin.dom.typeacte.TypeSousProduit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/application-contextDal.xml")
public class TypeSousProduitTest {

	@Autowired
	TypeSousProduitRepository repository;
	
	@Test
	public void test() {
		TypeSousProduit typeSousProduit=repository.findOne(new Long(1));
	System.out.println(typeSousProduit);
	}

}
