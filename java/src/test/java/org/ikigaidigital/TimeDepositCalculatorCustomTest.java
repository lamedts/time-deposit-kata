package org.ikigaidigital;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


//- The system should calculate the monthly interest based on the account type.
//- No interest will be added to any time deposit plans for the first 30 days.

//- Aside from the internal plan, which follows an auto-renewal strategy,
//      all existing time deposit plans should be terminated after 1 year.
//      After the plan is terminated, the balance of the time deposit account should become 0
//      as the funds will automatically be transferred to their savings account.


public class TimeDepositCalculatorCustomTest {

    enum Plan {
        A("basic", 0.01),
        B("student", 0.03),
        C("premium", 0.05),
        D("internal", 0.1);

        private String text;
        private double interest;

        Plan(String text, double interest) {
            this.text = text;
            this.interest = interest;
        }

        public static Plan fromString(String text) {
            for (Plan b : Plan.values()) {
                if (b.text.equalsIgnoreCase(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @ParameterizedTest
    @ValueSource(ints = { Integer.MIN_VALUE, -1, 0, 1, 2, 5, 10, 25, 29, 30, 31, Integer.MAX_VALUE })
    public void calculateInterest_Test_day(int days) {
        double money = 1234567.00;
        double expectedInterest = days > 30
            ? money * Plan.A.interest / 12
            : 0;

        TimeDepositCalculator calc = new TimeDepositCalculator();
        List<TimeDeposit> plans = Arrays.asList(
            new TimeDeposit("basic", money, days)
        );
        calc.calculateAmount(plans);

        Double actualTimeDeposit = plans.get(0).b;
        Double expectedTimeDeposit = money + calc.scaleUp(expectedInterest);
        assertThat(actualTimeDeposit).isEqualTo(expectedTimeDeposit);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 1, 2, 5, 10, 25, 29, 30, 31, Double.MAX_VALUE })
    public void calculateInterest_Test_(double amount) {
        int days = 45;
        double money = amount;
        double expectedInterest = money * Plan.A.interest / 12;

        TimeDepositCalculator calc = new TimeDepositCalculator();
        List<TimeDeposit> plans = Arrays.asList(
            new TimeDeposit("basic", money, days)
        );
        calc.calculateAmount(plans);

        Double actualTimeDeposit = plans.get(0).b;
        Double expectedTimeDeposit = money + calc.scaleUp(expectedInterest);
        assertThat(actualTimeDeposit).isEqualTo(expectedTimeDeposit);
    }

    @ParameterizedTest
    @ValueSource(strings = { "basic", "student", "internal", "premium" })
    public void calculateInterest_Test_(String planName) {
        double interest = Plan.fromString(planName).interest;
        int days = 46;
        double money = 1234567.00;
        double expectedInterest = money * interest / 12;

        TimeDepositCalculator calc = new TimeDepositCalculator();
        List<TimeDeposit> plans = Arrays.asList(
            new TimeDeposit(planName, money, days)
        );
        calc.calculateAmount(plans);

        Double actualTimeDeposit = plans.get(0).b;
        Double expectedTimeDeposit = money + calc.scaleUp(expectedInterest);
        assertThat(actualTimeDeposit).isEqualTo(expectedTimeDeposit);
    }
}
