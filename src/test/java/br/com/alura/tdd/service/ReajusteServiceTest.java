package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    @Test
    public void reajusteDeveSerDeTresPorCentoQuandoDesempenhoForADesejar(){

        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("10000.00"));
        service.aplicarReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("10300.00"),funcionario.getSalario());
    }

    @Test
    public void reajusteDeveSerDeQuinzePorCentoQuandoDesempenhoForBom(){

        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Irineu", LocalDate.now(), new BigDecimal("1000.00"));
        service.aplicarReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"),funcionario.getSalario());
    }

    @Test
    public void reajusteDeveSerDeVintePorCentoQuandoDesempenhoForOtimo(){

        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Berenice", LocalDate.now(), new BigDecimal("1000.00"));
        service.aplicarReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"),funcionario.getSalario());
    }
}
