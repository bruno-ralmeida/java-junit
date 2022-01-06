package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    private BonusService service;
    private Funcionario funcionario;
    private BigDecimal bonus;
    private BigDecimal expectedBonus;

    @BeforeEach
    public void inital() {
        service = new BonusService();
        funcionario = new Funcionario("Bruno", LocalDate.now(), new BigDecimal(2500));
    }

    @Test
    void bonusDeveSerZeroParaFuncionariosComSalariosAltos() {
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Ana", LocalDate.now(), new BigDecimal(25000)))
        );
    }

    @Test
    void bonusDeveSerDezPorCentoDoSalario() {
        bonus = service.calcularBonus(funcionario);
        expectedBonus = new BigDecimal("250.00");
        assertEquals(expectedBonus, bonus);
    }

    @Test
    void bonusDeveSerOLimitedaBonificacao() {
        bonus = service.calcularBonus(funcionario);
        expectedBonus = new BigDecimal("250.00");
        assertEquals(expectedBonus, bonus);
    }
}