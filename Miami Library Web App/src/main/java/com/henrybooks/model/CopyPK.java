package com.henrybooks.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;

public class CopyPK implements Serializable {
    private String bookCode;
    private BigInteger branchNum;
    private BigInteger copyNum;

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

    @Column(name = "copynum")
    @Id
    public BigInteger getCopyNum() {
        return copyNum;
    }

    public void setCopyNum(BigInteger copyNum) {
        this.copyNum = copyNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CopyPK copyPK = (CopyPK) o;

        if (bookCode != null ? !bookCode.equals(copyPK.bookCode) : copyPK.bookCode != null) return false;
        if (branchNum != null ? !branchNum.equals(copyPK.branchNum) : copyPK.branchNum != null) return false;
        if (copyNum != null ? !copyNum.equals(copyPK.copyNum) : copyPK.copyNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookCode != null ? bookCode.hashCode() : 0;
        result = 31 * result + (branchNum != null ? branchNum.hashCode() : 0);
        result = 31 * result + (copyNum != null ? copyNum.hashCode() : 0);
        return result;
    }
}
