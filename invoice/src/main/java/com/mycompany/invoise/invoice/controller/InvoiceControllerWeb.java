package com.mycompany.invoise.invoice.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class InvoiceControllerWeb {
/*
    private final InvoiceServiceInterface invoiceService;

    public InvoiceControllerWeb(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    @PostMapping("create")
    public String createInvoice(@Valid @ModelAttribute InvoiceForm invoiceForm, BindingResult results) {
        System.out.println("create");
        if (results.hasErrors()) {
            return "invoice-create-form";
        }
        Invoice invoice = new Invoice();
        Customer customer=new Customer(invoiceForm.getCustomerName());
        invoice.setCustomer(customer);
        Address adress=new Address(invoiceForm.getStreetName(),invoiceForm.getStreetNumber(),invoiceForm.getCity(),invoiceForm.getZipCode(), invoiceForm.getCountry());
        customer.setAddress(adress);
        invoice.setOrderNumber(invoiceForm.getOrderNumber());
        invoiceService.createInvoice(invoice);
        return "invoice-created";
    }
*/
    @GetMapping("home")
    public String displayHome(Model model) {
        System.out.println("La méthode display Home a été invoquée");
        return "invoice-home";
    }
/*
   /* @GetMapping("{id}")
    public String displayInvoice(@PathVariable("id") String number, Model model) {
        System.out.println("La méthode displayInvoice a été invoquée");

        model.addAttribute("invoice", invoiceService.getInvoiceByNumber(number));
        //List<Invoice> invoices=invoiceService.getInvoiceList();
        return "invoice-details";
    }*/
/*
    @GetMapping("create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice) {
        System.out.println("displayinvoicecreate form");
        return "invoice-create-form";
    }*/
}