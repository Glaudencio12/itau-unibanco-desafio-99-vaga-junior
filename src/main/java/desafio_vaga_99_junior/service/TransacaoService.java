package desafio_vaga_99_junior.service;

import desafio_vaga_99_junior.dto.TransacaoDTO;
import desafio_vaga_99_junior.exception.BadRequestException;
import desafio_vaga_99_junior.exception.UnprocessableEntityException;
import desafio_vaga_99_junior.mapper.ObjectMapper;
import desafio_vaga_99_junior.model.Transacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class TransacaoService {
    private final static Logger logger = LoggerFactory.getLogger("TransacaoService");
    @Autowired
    TransacoesRepository TransacoesRepository;

    public ResponseEntity<?> criarTransacao(TransacaoDTO transacao) {
        logger.info("Transação efetuada!");
        Transacao transacaoConvertida = ObjectMapper.parseObject(transacao, Transacao.class);

        OffsetDateTime agora = OffsetDateTime.now();
        if (transacaoConvertida == null) {
            throw new BadRequestException("Insira todos os dados nos respectivos campos!");
        } else if (transacaoConvertida.getValor() < 0 || transacaoConvertida.getDataHora().isAfter(agora)) {
            throw new UnprocessableEntityException("O valor precisa ser maior que zero e a transação não pode ser futura");
        } else {
            TransacoesRepository.getTransacoes().add(transacaoConvertida);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<Void> limparTransacoes() {
        logger.info("Transações limpas!");
        TransacoesRepository.getTransacoes().clear();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
