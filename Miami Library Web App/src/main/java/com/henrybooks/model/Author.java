package com.henrybooks.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name="author")
public class Author {

    @Id
    @Column(name = "authornum")
    private BigInteger authorNum;

    @Basic
    @Column(name = "authorlast")
    private String authorLast;

    @Basic
    @Column(name = "authorfirst")
    private String authorFirst;

    public BigInteger getAuthorNum() {
        return authorNum;
    }

    public void setAuthorNum(BigInteger authorNum) {
        this.authorNum = authorNum;
    }

    public String getAuthorLast() {
        return authorLast;
    }

    public void setAuthorLast(String authorLast) {
        this.authorLast = authorLast;
    }

    public String getAuthorFirst() {
        return authorFirst;
    }

    public void setAuthorFirst(String authorFirst) {
        this.authorFirst = authorFirst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (authorNum != null ? !authorNum.equals(author.authorNum) : author.authorNum != null) return false;
        if (authorLast != null ? !authorLast.equals(author.authorLast) : author.authorLast != null) return false;
        if (authorFirst != null ? !authorFirst.equals(author.authorFirst) : author.authorFirst != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = authorNum != null ? authorNum.hashCode() : 0;
        result = 31 * result + (authorLast != null ? authorLast.hashCode() : 0);
        result = 31 * result + (authorFirst != null ? authorFirst.hashCode() : 0);
        return result;
    }
}
