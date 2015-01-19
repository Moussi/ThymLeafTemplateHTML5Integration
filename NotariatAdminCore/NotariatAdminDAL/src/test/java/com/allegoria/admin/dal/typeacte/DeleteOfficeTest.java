package com.allegoria.admin.dal.typeacte;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.allegoria.admin.dal.repositories.office.OfficeRepository;
import com.allegoria.admin.dal.repositories.office.RibRepository;
import com.allegoria.admin.dom.office.Office;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/application-contextDal.xml")
public class DeleteOfficeTest {

	@Autowired
	OfficeRepository repository;
	@Autowired
	RibRepository ribRepository;
	@Test
	public void test() {
		Long id=new Long(8);
		Office office1 = repository.findOne(id);
		System.out.println(office1);
		repository.delete(office1);
		//repository.save(office2);
	}

}
