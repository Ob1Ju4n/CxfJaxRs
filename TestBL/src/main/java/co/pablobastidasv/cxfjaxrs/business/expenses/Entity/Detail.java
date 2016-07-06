package co.pablobastidasv.cxfjaxrs.business.expenses.entity;

import java.math.BigDecimal;

/**
 * Created by j.ortiz on 4/28/2016.
 */
public class Detail {

    private String id;
    private String description;
    private Money value;

    public Detail(){}

    public Detail(String description, Money value){

        this.description = description;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Money getValue() {
        return value;
    }

    public void setValue(Money value) {
        this.value = value;
    }
}
