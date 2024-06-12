package com.mycompany.invoise.core.service;

import com.mycompany.invoise.core.entity.Invoice;

public interface InvoiceServiceInterface {
    Invoice createInvoice(Invoice invoice);
    Iterable<Invoice> getInvoiceList();
    Invoice getInvoiceByNumber(String number);
}