package desafio_vaga_99_junior.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstatisticasDTO {
    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;
}
