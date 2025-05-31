package desafio_vaga_99_junior.service;

import desafio_vaga_99_junior.model.Transacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Service
public class TransacoesRepository {
    private final List<Transacao> transacoes = new ArrayList<>();
}
