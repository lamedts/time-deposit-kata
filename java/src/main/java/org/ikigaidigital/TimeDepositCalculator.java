package org.ikigaidigital;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class TimeDepositCalculator {

    public double calculateInterest(TimeDeposit timeDeposit) {
            double interest = 0;
            if (timeDeposit.days > 30) {
                if (timeDeposit.n.equalsIgnoreCase("student")) {
                    if (timeDeposit.days < 366) {
                        interest += timeDeposit.b * 0.03 / 12;
                    }
                } else if (timeDeposit.n.equalsIgnoreCase("premium")) {
                    if (timeDeposit.days > 45) {
                        interest += timeDeposit.b * 0.05 / 12;
                    }
                } else if (timeDeposit.n.equalsIgnoreCase("internal")) {
                    interest += timeDeposit.b * 0.1 / 12;
                } else if (timeDeposit.n.equalsIgnoreCase("basic")) {
                    interest += timeDeposit.b * 0.01 / 12;
                }
            }
            return interest;
    }

    public void calculateAmount(List<TimeDeposit> xs) {
        for (TimeDeposit timeDeposit : xs) {
            timeDeposit.b += scaleUp(calculateInterest(timeDeposit));
        }
    }

    public double scaleUp(Double amount) {
        return BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
