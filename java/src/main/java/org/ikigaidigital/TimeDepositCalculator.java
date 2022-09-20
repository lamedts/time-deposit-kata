package org.ikigaidigital;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class TimeDepositCalculator {
    public void calculateInterest(List<TimeDeposit> xs) {
        for (int i = 0; i < xs.size(); i++) {
            double a = 0;

            if (xs.get(i).days > 30) {
                if (xs.get(i).n == "student") {
                    if (xs.get(i).days < 366) {
                        a += xs.get(i).b * 0.03 / 12;
                    }
                } else if (xs.get(i).n == "premium") {
                    if (xs.get(i).days > 45) {
                        a += xs.get(i).b * 0.05 / 12;
                    }
                } else if (xs.get(i).n == "internal") {
                    a += xs.get(i).b * 0.1 / 12;
                } else if (xs.get(i).n == "basic") {
                    a += xs.get(i).b * 0.01 / 12;
                }
            }

            BigDecimal a2d = new BigDecimal(a).setScale(2, RoundingMode.HALF_UP);
            xs.get(i).b += a2d.doubleValue();
        }
    }
}
