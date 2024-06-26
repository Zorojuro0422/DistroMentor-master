package com.group29.distromentorsystem.models;


import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.Set;


@Document("PaymentTransactions")
public class PaymentTransaction {

    @Id
    private String paymenttransactionid;

    private double amountdue;

    private LocalDate startingdate;

    private LocalDate enddate;

    private int installmentnumber;

    private boolean isPaid;

    private String orderid;

    private Set<PaymentReceipt> paymentreceipts ;


    public PaymentTransaction() {
    }

    public PaymentTransaction(String paymenttransactionid, double amountdue, LocalDate startingdate, LocalDate enddate, int installmentnumber, boolean isPaid, String orderid, Set<PaymentReceipt> paymentreceipts) {
        this.paymenttransactionid = paymenttransactionid;
        this.amountdue = amountdue;
        this.startingdate = startingdate;
        this.enddate = enddate;
        this.installmentnumber = installmentnumber;
        this.isPaid = isPaid;
        this.orderid = orderid;
        this.paymentreceipts = paymentreceipts;
    }

    public String getPaymenttransactionid() {
        return paymenttransactionid;
    }

    public void setPaymenttransactionid(String paymenttransactionid) {
        this.paymenttransactionid = paymenttransactionid;
    }

    public double getAmountdue() {
        return amountdue;
    }

    public void setAmountdue(double amountdue) {
        this.amountdue = amountdue;
    }

    public LocalDate getStartingdate() {
        return startingdate;
    }

    public void setStartingdate(LocalDate startingdate) {
        this.startingdate = startingdate;
    }

    public LocalDate getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    public int getInstallmentnumber() {
        return installmentnumber;
    }

    public void setInstallmentnumber(int installmentnumber) {
        this.installmentnumber = installmentnumber;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Set<PaymentReceipt> getPaymentreceipts() {
        return paymentreceipts;
    }

    public void setPaymentreceipts(Set<PaymentReceipt> paymentreceipts) {
        this.paymentreceipts = paymentreceipts;
    }




}
