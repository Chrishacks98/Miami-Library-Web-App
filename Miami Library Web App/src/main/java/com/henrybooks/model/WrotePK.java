package com.henrybooks.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;

public class WrotePK implements Serializable {
    private String bookCode;
    private BigInteger authorNum;

    @Column(name = "bookcode")
    @Id
    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    @Column(name = "authornum")
    @Id
    public BigInteger getAuthorNum() {
        return authorNum;
    }

    public void setAuthorNum(BigInteger authorNum) {
        this.authorNum = authorNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WrotePK wrotePK = (WrotePK) o;

        if (bookCode != null ? !bookCode.equals(wrotePK.bookCode) : wrotePK.bookCode != null) return false;
        if (authorNum != null ? !authorNum.equals(wrotePK.authorNum) : wrotePK.authorNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookCode != null ? bookCode.hashCode() : 0;
        result = 31 * result + (authorNum != null ? authorNum.hashCode() : 0);
        return result;
    }
}
