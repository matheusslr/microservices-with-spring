package com.matheusslr.bookservice.proxy;

import com.matheusslr.bookservice.response.Cambio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cambio-service")
public interface CambioProxy {
    @GetMapping("/cambio-service/{amount}/{from}/{to}")
    public Cambio getCambio(
            @PathVariable(value = "amount") Double amount,
            @PathVariable(value = "from") String from,
            @PathVariable(value = "to") String to
    );
}