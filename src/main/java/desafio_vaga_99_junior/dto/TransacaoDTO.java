package desafio_vaga_99_junior.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import desafio_vaga_99_junior.model.Transacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransacaoDTO extends Transacao {
    private double valor;
    private OffsetDateTime dataHora;
}
