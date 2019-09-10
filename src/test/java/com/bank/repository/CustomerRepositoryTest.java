package com.bank.repository;

import com.bank.Application;
import com.bank.model.Account;
import com.bank.model.Customer;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CustomerRepositoryTest {

	@Autowired
	private DataSource dataSource;



	@Test
	public void testDatabaseProvider() throws Exception {
		String databaseUrl = this.dataSource.getConnection().getMetaData().getURL();
		assertThat(databaseUrl).contains("h2");
	}

}
