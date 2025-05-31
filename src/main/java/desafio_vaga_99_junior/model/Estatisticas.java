package desafio_vaga_99_junior.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estatisticas {
    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;
}
