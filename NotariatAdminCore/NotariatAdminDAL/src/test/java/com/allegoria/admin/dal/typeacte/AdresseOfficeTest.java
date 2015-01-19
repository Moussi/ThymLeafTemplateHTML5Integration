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
public class AdresseOfficeTest {

	@Autowired
	OfficeRepository repository;
	@Autowired
	RibRepository ribRepository;
	@Test
	public void test() {
		Office office1 = repository.findAll().get(0);
		Office office2 = new Office();
		office2.setAdresseFk(office1.getAdresseFk());
		office2.setAlerteReponseCourrier(2);
		office2.setCodeApe("codeApeTest");
		office2.setCodeCsn("codeCsn");
		office2.setCoordonneeFk(office1.getCoordonneeFk());
		office2.setDernierNumeroArchive("dernierNumeroArchive");
		office2.setNom("office2");
		office2.setNumeroAgree("numeroAgree");
		office2.setNumeroArchiveAuto(false);
		office2.setNumeroCrpcen("numeroCrpcen");
		office2.setNumeroSiren("numeroSiren");
		office2.setNumeroTva("numeroTva");
		office2.setNumeroUrssaf("numeroUrssaf");
		office2.setPoidMaxMicen(null);
		office2.setPoidMaxMicenAvecMentions(null);
		office2.setPoidMaxMicenAvecMentionsCritique(null);
		office2.setRepertoireNumeroContinu(null);
		office2.setServeurMicen("serveurMicen");
		office2.setStatut("");
		office2.setVersioning(1);
		office2.setVersionMetaSpecifiquesMicen("versionMetaSpecifiquesMicen");
		office2.setVersionXsdMicen("versionXsdMicen");
	
		repository.save(office2);
	}

}
