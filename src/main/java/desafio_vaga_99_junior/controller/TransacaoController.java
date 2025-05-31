package desafio_vaga_99_junior.controller;

import desafio_vaga_99_junior.dto.TransacaoDTO;
import desafio_vaga_99_junior.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class TransacaoController {
    @Autowired
    TransacaoService service;

    @PostMapping("/transacao")
    public ResponseEntity<?> receberTransacoes(@RequestBody TransacaoDTO transacao) {
        return service.criarTransacao(transacao);
    }

    @DeleteMapping("/transacao")
    public ResponseEntity<?> limparTrancacoes() {
        return service.limparTransacoes();
    }
}
