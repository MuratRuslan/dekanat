package kg.kgiai.dekanat.rest_api;

import kg.kgiai.dekanat.rest_api.repository.GruppaRepository;
import kg.kgiai.dekanat.rest_api.repository.RoomRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	GruppaRepository gruppaRepository;

	@Autowired
	RoomRepository roomRepository;

	@PostConstruct
	void init() {

	}

	@Test
	public void contextLoads() {
	}

	@Test
	@Transactional
	@Rollback
	public void testGruppaRepository() {
		Assert.assertNotNull(gruppaRepository.findAll());
	}

	@Test
	@Transactional
	@Rollback
	public void testRoomRep() {
		Assert.assertNotNull(roomRepository.findAll());
	}

}
