package com.matheusslr.cambioservice.controller;

import com.matheusslr.cambioservice.model.Cambio;
import com.matheusslr.cambioservice.service.CambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("cambio-service")
public class CambioController {
    @Autowired
    private CambioService cambioService;

    @GetMapping("/{amount}/{from}/{to}")
    public Cambio getCambio(
            @PathVariable(value = "amount") BigDecimal amount,
            @PathVariable(value = "from") String from,
            @PathVariable(value = "to") String to
    ) {
        return cambioService.getCambio(amount, from, to);
    }
}
