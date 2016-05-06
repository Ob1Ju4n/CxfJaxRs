package co.pablobastidasv.cxfjars.business.expenses.entity;

import java.math.BigDecimal;

/**
 * Created by j.ortiz on 4/28/2016.
 */
public class Detail {

    private String id;
    private String description;
    private BigDecimal value;

    public Detail(){}

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

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
