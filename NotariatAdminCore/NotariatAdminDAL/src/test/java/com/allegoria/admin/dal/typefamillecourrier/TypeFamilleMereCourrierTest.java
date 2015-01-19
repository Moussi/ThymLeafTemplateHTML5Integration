package com.allegoria.admin.dal.typefamillecourrier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.allegoria.admin.dal.repositories.typecomparutioncourrier.TypeComparutionCourrierRepository;
import com.allegoria.admin.dal.repositories.typecomparutioncourrier.TypeCourrierRepository;
import com.allegoria.admin.dal.repositories.typefamillecourrier.TypeFamilleMereCourrierRepository;
import com.allegoria.admin.dom.typefamillecourrier.TypeComparutionCourrier;
import com.allegoria.admin.dom.typefamillecourrier.TypeCourrier;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/application-contextDal.xml")
public class TypeFamilleMereCourrierTest {

	@Autowired
	TypeFamilleMereCourrierRepository typeFamilleMereCourrierRepository;
	
	
	@Test
	public void test() {
	System.out.println(typeFamilleMereCourrierRepository.findAll().size());
	}
	

}
