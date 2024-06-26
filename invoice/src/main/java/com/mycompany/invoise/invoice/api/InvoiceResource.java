package com.mycompany.invoise.invoice.api;


import com.mycompany.invoise.core.entity.customer.Address;
import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.core.entity.invoice.Invoice;
import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("invoice")
public class InvoiceResource {

    private final InvoiceServiceInterface invoiceService;
    private final RestTemplate restTemplate;

    public InvoiceResource(InvoiceServiceInterface invoiceService, RestTemplate restTemplate) {
        this.invoiceService = invoiceService;
        this.restTemplate = restTemplate;
    }

   /* @PostMapping
    public Invoice create(@RequestBody Invoice invoice) {
        return invoiceService.createInvoice(invoice);
    }
*/
    String urlCustomer ="http://customer-service/customer/";

    @GetMapping
    public Iterable<Invoice> list() {
        System.out.println("La méthode iterable list on display Home a été invoquée");
        Iterable<Invoice> invoices = invoiceService.getInvoiceList();
        invoices.forEach(invoice -> {
                invoice.setCustomer(restTemplate.getForObject(urlCustomer +invoice.getIdCustomer(),
                        Customer.class));
    });
        return invoices;
}

    @GetMapping("{id}")
    public Invoice get(@PathVariable("id") String number) {
        System.out.println("La méthode displayInvoice get Invoice a été invoquée");
        Invoice invoice =invoiceService.getInvoiceByNumber(number);
        final Customer customer =restTemplate.getForObject(urlCustomer +invoice.getIdCustomer(),
                Customer.class);
        final Address adress=restTemplate.getForObject(urlCustomer +invoice.getIdCustomer(),
                Address.class);
    customer.setAddress(adress);
    invoice.setCustomer(customer);
    return invoice;
    }
/*
    @GetMapping("create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice) {
        //vous pourriez même supprimer l'annotation @ModelAttribute si vous ne comptez
        //pas donner un identifiant personnalisé au backing bean
        return "invoice-create-form";
    }*/

    public RestTemplate getRestTemplate() {return restTemplate;}
    public InvoiceServiceInterface getInvoiceService() {return invoiceService;}
}