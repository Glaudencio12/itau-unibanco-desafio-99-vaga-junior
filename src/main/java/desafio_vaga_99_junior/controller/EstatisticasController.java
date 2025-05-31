package desafio_vaga_99_junior.controller;

import desafio_vaga_99_junior.dto.EstatisticasDTO;
import desafio_vaga_99_junior.service.EstatisticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EstatisticasController {
    @Autowired
    EstatisticasService service;

    @GetMapping("/estatisticas")
    public EstatisticasDTO calcularEstatisticas() {
        return service.calcularEstatitisticas();
    }
}
