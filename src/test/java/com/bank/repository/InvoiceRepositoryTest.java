package com.bank.repository;

import com.bank.Application;
import com.bank.model.Invoice;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class InvoiceRepositoryTest {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Test
    public void shouldCreateInvoice() {
        Invoice newInvoice = new Invoice("John", "Smith", 200);
        invoiceRepository.save(newInvoice);

        List<Invoice> retrievedInvoices = invoiceRepository.findByLastName("Smith");
        Assertions.assertThat(retrievedInvoices.get(0).getAmount()).isEqualTo(200);

    }


}
