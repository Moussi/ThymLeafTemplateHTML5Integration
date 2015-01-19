package com.allegoria.admin.dal.typefamillecourrier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.allegoria.admin.dal.repositories.typecomparutioncourrier.TypeComparutionCourrierRepository;
import com.allegoria.admin.dal.repositories.typecomparutioncourrier.TypeCourrierRepository;
import com.allegoria.admin.dom.typefamillecourrier.TypeComparutionCourrier;
import com.allegoria.admin.dom.typefamillecourrier.TypeCourrier;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/application-contextDal.xml")
public class TypeComparutionCourrierTest {

	@Autowired
	TypeComparutionCourrierRepository repository;
	@Autowired
	TypeCourrierRepository typecourrierrepository;
	
	@Test
	public void test() {
		TypeComparutionCourrier typeComparutionCourrier=new TypeComparutionCourrier();//.findOne(new Long(1));
	typeComparutionCourrier.setTypeComparution("aaaaa");
	TypeCourrier typec1=new TypeCourrier();
	typec1.setCommentaire("xsxsxsx");
	TypeCourrier typec2=new TypeCourrier();
	typec2.setCommentaire("125545");
	typeComparutionCourrier.getTypeCourriers().add(typec1);
	typeComparutionCourrier.getTypeCourriers().add(typec2);
	
		System.out.println(typeComparutionCourrier);
	for(TypeCourrier typeCourrier:typeComparutionCourrier.getTypeCourriers())
	{
		System.out.println(typeCourrier);
	}
//	typeComparutionCourrier.getTypeCourriers().add(typecourrierrepository.findOne(new Long(200)));
	System.out.println(("*********"));
	for(TypeCourrier typeCourrier:typeComparutionCourrier.getTypeCourriers())
	{
		System.out.println(typeCourrier);
	}
	repository.save(typeComparutionCourrier);
	}
	
	

}
