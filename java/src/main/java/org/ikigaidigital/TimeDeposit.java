package org.ikigaidigital;

public class TimeDeposit {
    public String name;
    public Double balance;
    public int daysSinceDeposited;

    public TimeDeposit(String name, Double balance, int daysSinceDeposited) {
        this.name = name;
        this.balance = balance;
        this.daysSinceDeposited = daysSinceDeposited;
    }
}
