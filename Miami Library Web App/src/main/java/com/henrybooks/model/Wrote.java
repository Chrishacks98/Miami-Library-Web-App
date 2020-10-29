package com.henrybooks.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@IdClass(WrotePK.class)
public class Wrote {
    private String bookCode;
    private BigInteger authorNum;
    private BigInteger sequence;

    @Id
    @Column(name = "bookcode")
    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    @Id
    @Column(name = "authornum")
    public BigInteger getAuthorNum() {
        return authorNum;
    }

    public void setAuthorNum(BigInteger authorNum) {
        this.authorNum = authorNum;
    }

    @Basic
    @Column(name = "sequence")
    public BigInteger getSequence() {
        return sequence;
    }

    public void setSequence(BigInteger sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wrote wrote = (Wrote) o;

        if (bookCode != null ? !bookCode.equals(wrote.bookCode) : wrote.bookCode != null) return false;
        if (authorNum != null ? !authorNum.equals(wrote.authorNum) : wrote.authorNum != null) return false;
        if (sequence != null ? !sequence.equals(wrote.sequence) : wrote.sequence != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookCode != null ? bookCode.hashCode() : 0;
        result = 31 * result + (authorNum != null ? authorNum.hashCode() : 0);
        result = 31 * result + (sequence != null ? sequence.hashCode() : 0);
        return result;
    }
}
