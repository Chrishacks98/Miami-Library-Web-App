package com.henrybooks.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@IdClass(InventoryPK.class)
public class Inventory {
    private String bookCode;
    private BigInteger branchNum;
    private BigInteger onHand;

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

    @Basic
    @Column(name = "onhand")
    public BigInteger getOnHand() {
        return onHand;
    }

    public void setOnHand(BigInteger onHand) {
        this.onHand = onHand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inventory inventory = (Inventory) o;

        if (bookCode != null ? !bookCode.equals(inventory.bookCode) : inventory.bookCode != null) return false;
        if (branchNum != null ? !branchNum.equals(inventory.branchNum) : inventory.branchNum != null) return false;
        if (onHand != null ? !onHand.equals(inventory.onHand) : inventory.onHand != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookCode != null ? bookCode.hashCode() : 0;
        result = 31 * result + (branchNum != null ? branchNum.hashCode() : 0);
        result = 31 * result + (onHand != null ? onHand.hashCode() : 0);
        return result;
    }
}
