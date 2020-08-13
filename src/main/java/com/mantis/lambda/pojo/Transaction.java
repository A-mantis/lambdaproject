package com.mantis.lambda.pojo;

/**
 * @Description:
 * @author: wei.wang
 * @since: 2020/8/12 11:27
 * @history: 1.2020/8/12 created by wei.wang
 */
public class Transaction {

    private Trader trader;
    private int year;
    private int value;
    private String currency;

    public Transaction(Trader trader,int year,int value,String currency){
        this.trader = trader;
        this.year = year;
        this.value = value;
        this.currency = currency;
    }

    public Trader getTrader(){
        return trader;
    }
    public int getYear(){
        return year;
    }
    public int getValue(){
        return value;
    }
    public String getCurrency(){
        return currency;
    }

    @Override
    public String toString(){
        return "i am transaction : my trader is : "
                + trader.getName()
                + " ; my year is : "
                + year
                + " ; my value is : "
                + value
                + " ; my currency is : "
                + currency;
    }
}