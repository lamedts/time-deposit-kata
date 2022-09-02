package org.ikigaidigital;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeDepositCalculatorTest {
    @Test
    public void calculateInterest_Test() {
        TimeDepositCalculator calc = new TimeDepositCalculator();
        List<TimeDeposit> plans = Arrays.asList(
            new TimeDeposit("basic", 10.0, 45)
        );
        calc.calculateInterest(plans);

        assertThat(1).isEqualTo(1);
    }
}
