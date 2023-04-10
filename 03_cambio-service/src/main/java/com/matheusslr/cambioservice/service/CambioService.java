package com.matheusslr.cambioservice.service;

import com.matheusslr.cambioservice.model.Cambio;
import com.matheusslr.cambioservice.repository.CambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CambioService {
    @Autowired
    private Environment environment;
    @Autowired
    private CambioRepository cambioRepository;

    public Cambio getCambio(BigDecimal amount, String from, String to) {
        var cambio = cambioRepository.findByFromAndTo(from, to);
        if (cambio == null) throw new RuntimeException("Unsupported Currency");

        var port = environment.getProperty("local.server.port");
        cambio.setEnvironment(port);

        BigDecimal conversionFactor = cambio.getConversionFactor();
        BigDecimal convertedValue = conversionFactor.multiply(amount);
        cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));

        return cambio;
    }
}
