package desafio_vaga_99_junior.service;

import desafio_vaga_99_junior.dto.EstatisticasDTO;
import desafio_vaga_99_junior.mapper.ObjectMapper;
import desafio_vaga_99_junior.model.Estatisticas;
import desafio_vaga_99_junior.model.Transacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstatisticasService {
    private static final Logger logger = LoggerFactory.getLogger("EstatisticasService");
    @Autowired
    TransacoesRepository TransacoesRepository;

    public EstatisticasDTO calcularEstatitisticas() {
        logger.info("Cálculo de estatisticas realizado!");
        OffsetDateTime agora = OffsetDateTime.now();
        OffsetDateTime limite = agora.minusSeconds(60);

        List<Transacao> ultimasTransacoes = new ArrayList<>();
        List<Transacao> listaTransacao = TransacoesRepository.getTransacoes();

        for (Transacao t : listaTransacao) {
            if (t.getDataHora().isAfter(limite) && t.getDataHora().isBefore(agora)) {
                ultimasTransacoes.add(t);
            }
        }

        DoubleSummaryStatistics dados = ultimasTransacoes.stream().collect(Collectors.summarizingDouble(Transacao::getValor));

        Estatisticas estatisticas = new Estatisticas();
        estatisticas.setCount(dados.getCount());
        estatisticas.setSum(dados.getSum());
        estatisticas.setMax(dados.getCount() > 0 ? dados.getMax() : 0);
        estatisticas.setMin(dados.getCount() > 0 ? dados.getMin() : 0);
        estatisticas.setAvg(dados.getAverage());

        return ObjectMapper.parseObject(estatisticas, EstatisticasDTO.class);
    }
}
