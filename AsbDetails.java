package com.rhbgroup.dcpbo.customer.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.rhbgroup.dcp.model.Capsule;
import com.rhbgroup.dcpbo.customer.contract.BoData;

import com.rhbgroup.dcpbo.customer.contract.CapsuleToDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AsbDetails implements BoData{
    private String paymentDueDate;
    private String monthlyPayment;
    private String accountNo;
    private String overdueAmount;
    private String loanAmount;
    private String remainingAmount;
    private String typeOfTerm;
    private String originalTenure;
    private String remainingTenure;
    private String interestRate;
}