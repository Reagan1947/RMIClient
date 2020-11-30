import java.io.Serializable;
import java.util.Date;

public class Receipt extends Car implements Serializable {

    private String receiptID;
    private String receiptPurchaser;
    private String  receiptDate;

    public String getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    public String getReceiptPurchaser() {
        return receiptPurchaser;
    }

    public void setReceiptPurchaser(String receiptPurchaser) {
        this.receiptPurchaser = receiptPurchaser;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }
}
