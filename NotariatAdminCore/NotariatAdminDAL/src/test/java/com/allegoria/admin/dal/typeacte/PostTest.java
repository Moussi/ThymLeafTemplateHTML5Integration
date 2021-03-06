package com.allegoria.admin.dal.typeacte;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.allegoria.admin.dal.repositories.PostRepository;
import com.allegoria.admin.dal.repositories.typecritereautogeneration.TypeCritereAutoGenerationRepository;
import com.allegoria.admin.dom.Post;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/application.xml")
public class PostTest {

	@Autowired
	PostRepository repository;

	@Test
	public void test() {
		Post post = new Post();
		post.setDate(new Date());
		post.setNom("Second member");

		repository.save(post);

		Post dbpost = repository.findOne(post.getIdpost());
		assertNotNull(dbpost);

	}

}
