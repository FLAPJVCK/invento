package by.inventolabs.unauthorizeddeliveries.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Posting implements Serializable {
    @CsvBindByName (column = "Mat. Doc.")
    private long matDoc;
    @CsvBindByName (column = "Item")
    private int item;
    @CsvDate(value = "dd.mm.yyyy")
    @CsvBindByName (column = "Doc. Date")
    private Date docDate;
    @CsvDate(value = "dd.mm.yyyy")
    @CsvBindByName (column = "Pstng Date")
    private Date pstngDate;
    @CsvBindByName (column = "Material Description")
    private String materialDescription;
    @CsvBindByName (column = "Quantity")
    private int quantity;
    @CsvBindByName (column = "BUn")
    private String bUn;
    @CsvBindByName (column = "Amount LC")
    private String amountLC;
    @CsvBindByName (column = "Crcy")
    private String crcy;
    @CsvBindByName (column = "User Name")
    private String userName;
    private String isAuthorized;

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
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getbUn() {
        return bUn;
    }

    public void setbUn(String bUn) {
        this.bUn = bUn;
    }

    public String getAmountLC() {
        return amountLC;
    }

    public void setAmountLC(String amountLC) {
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

    public String getIsAuthorized() {
        return isAuthorized;
    }

    public void setIsAuthorized(String isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posting posting = (Posting) o;
        return matDoc == posting.matDoc && item == posting.item && quantity == posting.quantity && Objects.equals(docDate, posting.docDate) && Objects.equals(pstngDate, posting.pstngDate) && Objects.equals(materialDescription, posting.materialDescription) && Objects.equals(bUn, posting.bUn) && Objects.equals(amountLC, posting.amountLC) && Objects.equals(crcy, posting.crcy) && Objects.equals(userName, posting.userName) && Objects.equals(isAuthorized, posting.isAuthorized);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matDoc, item, docDate, pstngDate, materialDescription, quantity, bUn, amountLC, crcy, userName, isAuthorized);
    }
}
