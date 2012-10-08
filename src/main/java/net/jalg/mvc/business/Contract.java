package net.jalg.mvc.business;

public class Contract {
	
	private String contractId;
	private String userId;
	private String status;
	
	public Contract(String contractId, String userId, String status) {
		super();
		this.contractId = contractId;
		this.userId = userId;
		this.status = status;
	}
	public String getContractId() {
		return contractId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public String getStatus() {
		return status;
	}
	
	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", userId=" + userId
				+ ", status=" + status + "]";
	}
}
