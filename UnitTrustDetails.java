package com.rhbgroup.dcpbo.customer.model;

import com.rhbgroup.dcp.investments.model.AccountHolderName;
import com.rhbgroup.dcp.investments.model.AccountStatus;
import com.rhbgroup.dcp.investments.model.SigningCondition;
import com.rhbgroup.dcp.investments.model.UnitTrustFunds;
import com.rhbgroup.dcpbo.customer.contract.BoData;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class UnitTrustDetails implements BoData {
	private String accountNo;
	private List<AccountHolderName> accountHolderName;
	private String lastPerformedTxnDate;
	private AccountStatus accountStatus;
	private SigningCondition signingCondition;
	private List<UnitTrustFunds> unitTrustFunds;
}

