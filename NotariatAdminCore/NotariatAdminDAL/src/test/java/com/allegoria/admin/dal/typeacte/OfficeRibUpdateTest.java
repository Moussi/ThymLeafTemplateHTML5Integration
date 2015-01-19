package com.allegoria.admin.dal.typeacte;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.allegoria.admin.dal.repositories.office.OfficeRepository;
import com.allegoria.admin.dom.office.Annexe;
import com.allegoria.admin.dom.office.DocumentFichier;
import com.allegoria.admin.dom.office.Office;
import com.allegoria.admin.dom.office.Rib;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/application-contextDal.xml")
public class OfficeRibUpdateTest {

	@Autowired
	OfficeRepository repository;

	@Test
	public void test() {
		Office office1 = repository.findOne(new Long(8));
		for(Rib rib:office1.getRibCollection())
		{
			System.out.println("ribbb =====>   "+rib.toString());
		}
		
		for(Annexe rib:office1.getAnnexeCollection())
		{
			System.out.println("annexes =====>   "+rib.toString());
		}
		
		for(DocumentFichier rib:office1.getDocumentFichierCollection())
		{
			System.out.println("docs =====>   "+rib.toString());
		}
	}

}
