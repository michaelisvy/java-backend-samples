package samples.completeapp.bank.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.*;

@EnabledOnOs({OS.WINDOWS, OS.MAC})
@ActiveProfiles("mysql")
public class CustomerRepositoryMySqlTest extends CustomerRepositoryTest {

    @Autowired
    private DataSource dataSource;

    @Test
    @Transactional
    @Override
    public void testDatabaseProvider() throws Exception {
        String databaseUrl = this.dataSource.getConnection().getMetaData().getURL();
        assertThat(databaseUrl).contains("mysql");
    }

}
