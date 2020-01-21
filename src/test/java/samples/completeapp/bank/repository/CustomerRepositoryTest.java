package samples.completeapp.bank.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private DataSource dataSource;


    @Test
    public void testDatabaseProvider() throws Exception {
        String databaseUrl = this.dataSource.getConnection().getMetaData().getURL();
        assertThat(databaseUrl).contains("h2");
    }

}
