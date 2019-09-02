package com.bank;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.*;

@ActiveProfiles("mysql")
public class CustomerRepositoryMySqlTest extends DefaultCustomerRepositoryTest {

	@Autowired
	private DataSource dataSource;

	@Test @Transactional @Override
	public void testDatabaseProvider() throws Exception {
		String databaseUrl = this.dataSource.getConnection().getMetaData().getURL();
		assertThat(databaseUrl).contains("mysql");
	}

}
