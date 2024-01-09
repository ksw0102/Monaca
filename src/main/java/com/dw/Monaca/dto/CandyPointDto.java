package com.dw.Monaca.dto;

public class CandyPointDto {

	 private Long attendanceId;
	 private Long candyId;
	 private Long examinationId;
	 private Long itemShopId;
	 private int useHistory;
	 private String description;
	
	 public CandyPointDto() {
		super();
	}

	public Long getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(Long attendanceId) {
		this.attendanceId = attendanceId;
	}

	public Long getCandyId() {
		return candyId;
	}

	public void setCandyId(Long candyId) {
		this.candyId = candyId;
	}

	public Long getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(Long examinationId) {
		this.examinationId = examinationId;
	}

	public Long getItemShopId() {
		return itemShopId;
	}

	public void setItemShopId(Long itemShopId) {
		this.itemShopId = itemShopId;
	}

	public int getUseHistory() {
		return useHistory;
	}

	public void setUseHistory(int useHistory) {
		this.useHistory = useHistory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	 
	 
}
