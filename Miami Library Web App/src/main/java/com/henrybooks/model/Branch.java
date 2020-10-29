package com.henrybooks.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity
public class Branch {
    private BigInteger branchNum;
    private String branchName;
    private String branchLocation;

    @Id
    @Column(name = "branchnum")
    public BigInteger getBranchNum() {
        return branchNum;
    }

    public void setBranchNum(BigInteger branchNum) {
        this.branchNum = branchNum;
    }

    @Basic
    @Column(name = "branchname")
    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Basic
    @Column(name = "branchlocation")
    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Branch branch = (Branch) o;

        if (branchNum != null ? !branchNum.equals(branch.branchNum) : branch.branchNum != null) return false;
        if (branchName != null ? !branchName.equals(branch.branchName) : branch.branchName != null) return false;
        if (branchLocation != null ? !branchLocation.equals(branch.branchLocation) : branch.branchLocation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = branchNum != null ? branchNum.hashCode() : 0;
        result = 31 * result + (branchName != null ? branchName.hashCode() : 0);
        result = 31 * result + (branchLocation != null ? branchLocation.hashCode() : 0);
        return result;
    }
}
