package co.pablobastidasv.cxfjaxrs.business.expenses.entity;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.ArrayList;


import java.util.Date;
import java.util.List;

/**
 * Created by j.ortiz on 4/27/2016.
 */
public class Expense {

    @Id
    private String id;
    private TransferType transferType;
    private List<Detail> details;
    private BigDecimal netWorth;
    private BigDecimal total;
    private Date creationDate;
    //TODO: Include attachment property

    public Expense(){}

    private Expense(Builder builder){

        id = builder.id;
        transferType = builder.transferType;
        details = builder.details;
        netWorth = builder.netWorth;
        total = builder.total;
        creationDate = builder.creationDate;

    }

    public String getId() {
        return id;
    }

    public TransferType getTransferType() {
        return transferType;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public BigDecimal getNetWorth() {
        return netWorth;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public static class Builder{

        private String id;
        private TransferType transferType;
        private List<Detail> details;
        private BigDecimal netWorth;
        private BigDecimal total;
        private Date creationDate;

        public Builder(){
            this.id = null;
            this.details = new ArrayList<>();
            this.creationDate = new Date();
        }

        public Builder id(String value){

            id = value;
            return this;
        }

        public Builder transferType(TransferType value){

            transferType = value;
            return this;
        }

        public Builder details(List<Detail> valueList){

            details = valueList;
            return this;
        }

        public Builder netWorth(BigDecimal value){

            netWorth = value;
            return this;
        }


        public Builder total(BigDecimal value){

            total = value;
            return this;
        }

        public Builder creationDate(Date value){

            creationDate = value;
            return this;
        }

        public Expense build(){
            return new Expense(this);
        }

    }

}
