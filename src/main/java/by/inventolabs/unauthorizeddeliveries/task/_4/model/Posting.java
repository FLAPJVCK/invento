package by.inventolabs.unauthorizeddeliveries.task._4.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Posting implements Serializable {
    private long matDoc;
    private int item;
    private Date docDate;
    private Date pstngDate;
    private String materialDescription;
    private int Quantity;
    private String bUn;
    private double amountLC;
    private String crcy;
    private String userName;

    public long getMatDoc() {
        return matDoc;
    }

    public void setMatDoc(long matDoc) {
        this.matDoc = matDoc;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public Date getPstngDate() {
        return pstngDate;
    }

    public void setPstngDate(Date pstngDate) {
        this.pstngDate = pstngDate;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getbUn() {
        return bUn;
    }

    public void setbUn(String bUn) {
        this.bUn = bUn;
    }

    public double getAmountLC() {
        return amountLC;
    }

    public void setAmountLC(double amountLC) {
        this.amountLC = amountLC;
    }

    public String getCrcy() {
        return crcy;
    }

    public void setCrcy(String crcy) {
        this.crcy = crcy;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Posting{" +
                "matDoc=" + matDoc +
                ", item=" + item +
                ", docDate=" + docDate +
                ", pstngDate=" + pstngDate +
                ", materialDescription='" + materialDescription + '\'' +
                ", Quantity=" + Quantity +
                ", bUn='" + bUn + '\'' +
                ", amountLC=" + amountLC +
                ", crcy='" + crcy + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posting posting = (Posting) o;
        return matDoc == posting.matDoc && item == posting.item && Quantity == posting.Quantity && Double.compare(posting.amountLC, amountLC) == 0 && Objects.equals(docDate, posting.docDate) && Objects.equals(pstngDate, posting.pstngDate) && Objects.equals(materialDescription, posting.materialDescription) && Objects.equals(bUn, posting.bUn) && Objects.equals(crcy, posting.crcy) && Objects.equals(userName, posting.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matDoc, item, docDate, pstngDate, materialDescription, Quantity, bUn, amountLC, crcy, userName);
    }
}
