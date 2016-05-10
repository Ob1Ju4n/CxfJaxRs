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

    public Expense(){
        this.details = new ArrayList<>();
        this.creationDate = new Date();
    }

    public Expense(TransferType transferType, List<Detail> details, BigDecimal netWorth, BigDecimal total) {
        this();
        this.transferType = transferType;
        this.details.addAll(details);
        this.netWorth = netWorth;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TransferType getTransferType() {
        return transferType;
    }

    public void setTransferType(TransferType transferType) {
        this.transferType = transferType;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public BigDecimal getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(BigDecimal netWorth) {
        this.netWorth = netWorth;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
