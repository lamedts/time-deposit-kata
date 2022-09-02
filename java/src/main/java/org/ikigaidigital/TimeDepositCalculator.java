package org.ikigaidigital;

import java.util.List;

public class TimeDepositCalculator {
    public void calculateInterest(List<TimeDeposit> xs) {
        for (int i = 0; i < xs.size(); i++) {
            double a = 0;

            if (xs.get(i).days >= 30) {
                if (xs.get(i).n == "student") {
                    if (xs.get(i).days < 366) {
                        a += xs.get(i).b * 0.03;
                    }
                } else if (xs.get(i).n == "premium") {
                    if (xs.get(i).days > 30) {
                        a += xs.get(i).b * 0.05;
                    }
                } else if (xs.get(i).n == "internal") {
                    a += xs.get(i).b * 0.1;
                } else if (xs.get(i).n == "basic") {
                    a += xs.get(i).b * 0.01;
                }
            }

            xs.get(i).b += a;
        }
    }
}
