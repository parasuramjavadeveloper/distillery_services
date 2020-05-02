package com.hpfs.distillery.retailer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="excise_duty")
public class TblExciseDuty {
    @Id
    @Column(name="challan_no")
    private String challanNo;
    @Column(name="challan_type")
    private String challanType;
    @Column(name="description")
    private String description;
    @Column(name="challan_date")
    @JsonIgnore
    private Timestamp dbChallaDate;
    @Column(name="transaction_type")
    private String transactionType;
    @Column(name="deposited_amount")
    private Double depositedAmount;
    @Column(name="opening_balance")
    private Double openinigBalance;
    @Column(name="credit")
    private Double credit;
    @Column(name="debit")
    private Double debit;
    @Column(name="closing_balance")
    private Double closingBalance;
    @Column(name="creation_date")
    private Timestamp creationDate;
    @Column(name="created_by")
    private String createdBy;
    @Column(name="updated_date")
    private Timestamp updatedDate;
    @Column(name="updated_by")
    private String updatedBy;

    @Transient
    private String challanDate;

    public String getChallanNo() {
        return challanNo;
    }

    public void setChallanNo(String challanNo) {
        this.challanNo = challanNo;
    }

    public String getChallanType() {
        return challanType;
    }

    public void setChallanType(String challanType) {
        this.challanType = challanType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDbChallaDate() {
        return dbChallaDate;
    }

    public void setDbChallaDate(Timestamp dbChallaDate) {
        this.dbChallaDate = dbChallaDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Double getDepositedAmount() {
        return depositedAmount;
    }

    public void setDepositedAmount(Double depositedAmount) {
        this.depositedAmount = depositedAmount;
    }

    public Double getOpeninigBalance() {
        return openinigBalance;
    }

    public void setOpeninigBalance(Double openinigBalance) {
        this.openinigBalance = openinigBalance;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }

    public Double getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(Double closingBalance) {
        this.closingBalance = closingBalance;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getChallanDate() {
        return challanDate;
    }

    public void setChallanDate(String challanDate) {
        this.challanDate = challanDate;
    }

/*
    @Id
    @Column(name="challan_no")
    public String challanNo;
    private String challanType;

    @Column(name="date_and_time")
    public String dateAndTime;

    @Column(name="challan_or_transdate")
    public String challanOrTransDate;

    @Column(name="description")
    public String description;

    @Column(name="transaction_type")
    public String transactionType;

    @Column(name="opening_bal")
    public double  openingBal;


    @Column(name="credit")
    public double credit;

    @Column(name="debit")pe
    public double debit;

    @Column(name="balance")
    public double balance;

    @Column(name="bank_name")
    public String bankName;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getChallnOrTransNumber() {
        return challnOrTransNumber;
    }

    public void setChallnOrTransNumber(String challnOrTransNumber) {
        this.challnOrTransNumber = challnOrTransNumber;
    }



    public String getChallanOrTransDate() {
        return challanOrTransDate;
    }

    public void setChallanOrTransDate(String challanOrTransDate) {
        this.challanOrTransDate = challanOrTransDate;
    }



    public double getOpeningBal() {
        return openingBal;
    }

    public void setOpeningBal(double openingBal) {
        this.openingBal = openingBal;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }*/


}
