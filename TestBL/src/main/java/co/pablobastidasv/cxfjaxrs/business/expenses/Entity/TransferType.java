package co.pablobastidasv.cxfjaxrs.business.expenses.entity;

/**
 * Created by j.ortiz on 4/28/2016.
 */
public class TransferType {

    private String id;
    private String transferCode;
    private String transferName;

    public TransferType(){}

    public TransferType(String transferCode, String transferName) {
        this.transferCode = transferCode;
        this.transferName = transferName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransferCode() {
        return transferCode;
    }

    public void setTransferCode(String transferCode) {
        this.transferCode = transferCode;
    }

    public String getTransferName() {
        return transferName;
    }

    public void setTransferName(String transferName) {
        this.transferName = transferName;
    }
}
