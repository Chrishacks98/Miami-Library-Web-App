package com.henrybooks.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;

public class InventoryPK implements Serializable {
    private String bookCode;
    private BigInteger branchNum;

    @Column(name = "bookcode")
    @Id
    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    @Column(name = "branchnum")
    @Id
    public BigInteger getBranchNum() {
        return branchNum;
    }

    public void setBranchNum(BigInteger branchNum) {
        this.branchNum = branchNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InventoryPK that = (InventoryPK) o;

        if (bookCode != null ? !bookCode.equals(that.bookCode) : that.bookCode != null) return false;
        if (branchNum != null ? !branchNum.equals(that.branchNum) : that.branchNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookCode != null ? bookCode.hashCode() : 0;
        result = 31 * result + (branchNum != null ? branchNum.hashCode() : 0);
        return result;
    }
}
