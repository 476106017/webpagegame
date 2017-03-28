import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import zdm.fate.Application;
import zdm.fate.domain.repository.PlayerStatusRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class test {

	@Autowired
	private PlayerStatusRepository playerStatusRepository;

	@Test
	public void repositoryTest() {

		System.out.println(playerStatusRepository.findOne(1).getTile().getId().toString());
	}
}
