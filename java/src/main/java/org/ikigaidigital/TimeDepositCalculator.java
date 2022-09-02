package org.ikigaidigital;

import java.util.List;

public class TimeDepositCalculator {
    public void calculateInterest(List<TimeDeposit> tda) {
        for (int i = 0; i < tda.size(); i++) {
            double a = 0;

            if (tda.get(i).daysSinceDeposited > 1) {
                if (tda.get(i).name == "student") {
                    if (tda.get(i).daysSinceDeposited < 366) {
                        a += tda.get(i).balance * 0.05;
                    }
                } else if (tda.get(i).name == "premium") {
                    if (tda.get(i).daysSinceDeposited > 30) {
                        a += tda.get(i).balance * 0.07;
                    }
                } else if (tda.get(i).name == "internal") {
                    a += tda.get(i).balance * 0.1;
                } else if (tda.get(i).name == "basic") {
                    a = 0;
                }
            }

            tda.get(i).balance += a;
        }
    }
}
