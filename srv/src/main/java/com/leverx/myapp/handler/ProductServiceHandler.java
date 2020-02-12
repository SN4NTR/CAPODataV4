package com.leverx.myapp.handler;

import cds.gen.productservice.Products;
import com.sap.cds.services.cds.CdsCreateEventContext;
import com.sap.cds.services.cds.CdsReadEventContext;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.After;
import com.sap.cds.services.handler.annotations.Before;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static cds.gen.productservice.Products_.CDS_NAME;
import static com.sap.cds.services.cds.CdsService.EVENT_CREATE;
import static com.sap.cds.services.cds.CdsService.EVENT_READ;

@Slf4j
@Component
@ServiceName("ProductService")
public class ProductServiceHandler implements EventHandler {

    @Before(event = EVENT_CREATE, entity = CDS_NAME)
    public void beforeCreate(List<Products> products) {
        int id = products.get(0).getId();
        log.info("Creating product with id = {}", id);
    }

    @On(event = EVENT_CREATE, entity = CDS_NAME)
    public void onCreate(CdsCreateEventContext context) {
        System.out.println("On creating...");
    }

    @After(event = EVENT_CREATE, entity = CDS_NAME)
    public void afterCreate(CdsCreateEventContext context) {
        System.out.println("After creating...");
    }

    @Before(event = EVENT_READ, entity = CDS_NAME)
    public void beforeRead(CdsReadEventContext context) {
        System.out.println(context);
    }
}
