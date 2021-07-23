package com.Emarket.Model;

public class Contractor {
    private int contractorid;
    private String contractorName;
    private String contractorDescription;

    public String getContractorDescription() {
        return contractorDescription;
    }

    public void setContractorDescription(String contractorDescription) {
        this.contractorDescription = contractorDescription;
    }

    public int getContractorid() {
        return contractorid;
    }

    public void setContractorid(int contractorid) {
        this.contractorid = contractorid;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    @Override
    public String toString() {
        return "Contractor{" +
                "contractorid=" + contractorid +
                ", contractorName='" + contractorName + '\'' +
                ", contractorDescription='" + contractorDescription + '\'' +
                '}';
    }
}

