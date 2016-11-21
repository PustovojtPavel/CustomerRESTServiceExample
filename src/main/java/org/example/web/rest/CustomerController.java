package org.example.web.rest;

import org.example.core.domain.Customer;
import org.example.core.service.CustomerService;
import org.example.web.vo.AddReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Path("/")
@Produces(MediaType.APPLICATION_JSON + CustomerController.CHARSET_UTF8)
@Component
public class CustomerController {

    final static String CHARSET_UTF8 = ";charset=UTF-8";

    @Autowired
    private CustomerService customerSrv;

    @POST
    @Path("get")
    public List<Customer> getAll() {
        return customerSrv.getAll();
    }

    @POST
    @Path("get/{customerId}")
    public Customer getCustomer(@PathParam("customerId") String customerId) {
        return customerSrv.findById(UUID.fromString(customerId));
    }

    @POST
    @Path("add")
    public void add(AddReq request) {
        if (request != null && (request.getName() != null && !request.getName().isEmpty())) {
            customerSrv.create(request.getName());
        }
    }
}
