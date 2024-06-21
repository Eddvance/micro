package com.mycompany.invoise.invoice.service.number;

import com.mycompany.invoise.core.entity.invoice.Invoice;

import com.mycompany.invoise.invoice.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class InvoiceServiceNumber implements InvoiceServiceInterface {

    //private final CustomerRepositoryInterface customerRepository;
    private final InvoiceRepositoryInterface invoiceRepository;

    public InvoiceServiceNumber(/*CustomerRepositoryInterface customerRepository, */@Qualifier("invoiceRepositoryInterface") InvoiceRepositoryInterface invoiceRepository) {
        //this.customerRepository = customerRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @Transactional
    public Invoice createInvoice(Invoice invoice) {
        //customerRepository.save(invoice.getCustomer());
        return invoiceRepository.save(invoice);
    }

    @Override
    public Iterable<Invoice> getInvoiceList() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceByNumber(String number) {
        return invoiceRepository.findById(number).orElseThrow();
    }
}