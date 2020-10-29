package com.henrybooks.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name="copy")
@IdClass(CopyPK.class)
public class Copy {
    private String bookCode;
    private BigInteger branchNum;
    private BigInteger copyNum;
    private String quality;
    private BigDecimal price;

    @Id
    @Column(name = "bookcode")
    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    @Id
    @Column(name = "branchnum")
    public BigInteger getBranchNum() {
        return branchNum;
    }

    public void setBranchNum(BigInteger branchNum) {
        this.branchNum = branchNum;
    }

    @Id
    @Column(name = "copynum")
    public BigInteger getCopyNum() {
        return copyNum;
    }

    public void setCopyNum(BigInteger copyNum) {
        this.copyNum = copyNum;
    }

    @Basic
    @Column(name = "quality")
    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Copy copy = (Copy) o;

        if (bookCode != null ? !bookCode.equals(copy.bookCode) : copy.bookCode != null) return false;
        if (branchNum != null ? !branchNum.equals(copy.branchNum) : copy.branchNum != null) return false;
        if (copyNum != null ? !copyNum.equals(copy.copyNum) : copy.copyNum != null) return false;
        if (quality != null ? !quality.equals(copy.quality) : copy.quality != null) return false;
        if (price != null ? !price.equals(copy.price) : copy.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookCode != null ? bookCode.hashCode() : 0;
        result = 31 * result + (branchNum != null ? branchNum.hashCode() : 0);
        result = 31 * result + (copyNum != null ? copyNum.hashCode() : 0);
        result = 31 * result + (quality != null ? quality.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
