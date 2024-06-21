package com.mycompany.invoise.invoice.repository.database;

/*
@Repository
public class InvoiceRepositoryDatabase implements InvoiceRepositoryInterface {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public InvoiceRepositoryDatabase(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Invoice create(Invoice invoice) {

        KeyHolder keyH = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO INVOICE(CUSTOMER_NAME,ORDER_NUMBER) VALUES (?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, invoice.getCustomerName());
            ps.setString(2, invoice.getOrderNumber());
            return ps;
        },keyH);

        invoice.setNumber(keyH.getKey().toString());
        return invoice;
    }

    @Override
    public List<Invoice> list() {
        return jdbcTemplate.query("SELECT INVOICE_NUMBER,CUSTOMER_NAME FROM INVOICE",
                (rs, rowNum) -> new Invoice(String.valueOf(rs.getLong("INVOICE_NUMBER")),
                 rs.getString("CUSTOMER_NAME")));

    }

    @Override
    public Invoice getById(String number) {
        return jdbcTemplate.queryForObject("SELECT INVOICE_NUMBER,CUSTOMER_NAME,ORDER_NUMBER FROM INVOICE WHERE INVOICE_NUMBER=?",
                new Object[]{number},
                (rs, rowNum) -> new Invoice(String.valueOf(rs.getLong("INVOICE_NUMBER")),
                        rs.getString("CUSTOMER_NAME"),
                        rs.getString("ORDER_NUMBER")));
    }
}

 */