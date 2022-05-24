package com.dto;

public class MmbrRegDto {
	private int memberID;
	private String memberName;
	private Address address;
	private String memberType;
	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public MmbrRegDto(int memberID, String memberName, Address address, String memberType) {
		super();
		this.memberID = memberID;
		this.memberName = memberName;
		this.address = address;
		this.memberType = memberType;
	}
	public MmbrRegDto() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MmbrRegDto [memberID=" + memberID + ", memberName=" + memberName + ", address=" + address
				+ ", memberType=" + memberType + "]";
	}
	
	
}