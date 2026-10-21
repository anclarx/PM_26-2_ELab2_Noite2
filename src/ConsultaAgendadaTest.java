import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConsultaAgendadaTest {

    ConsultaAgendada consulta;
    String nomePaciente;
    EEspecialidade especialidade;
    double valorConsulta;
    double valorEsperado;

    final double PCT_DESCONTO = 0.30;

    @BeforeEach
    public void setUp() {
        nomePaciente = "Taylor Swift";
        especialidade = EEspecialidade.DERMATOLOGIA;
    }

    @Test
    public void valorConsultaComDesconto() {
        // Arrange
        LocalDateTime horarioAgendado = LocalDateTime.of(2026, 11, 12, 9, 13);
        consulta = new ConsultaAgendada(nomePaciente, horarioAgendado, especialidade);
        valorEsperado = especialidade.valor() * PCT_DESCONTO;

        // Act
        valorConsulta = consulta.valorConsulta();

        // Assert
        assertEquals(valorEsperado, valorConsulta, 0.1);
    }

    @Test
    public void valorConsultaSemDesconto() {
        // Arrange
        LocalDateTime horarioAgendado = LocalDateTime.of(2026, 10, 25, 9, 13);
        consulta = new ConsultaAgendada(nomePaciente, horarioAgendado, especialidade);
        valorEsperado = especialidade.valor();

        // Act
        valorConsulta = consulta.valorConsulta();

        // Assert
        assertEquals(valorEsperado, valorConsulta, 0.1);
    }
}
