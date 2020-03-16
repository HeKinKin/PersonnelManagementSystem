package com.igeek.bean;

public class Training {
	private int trainingid;
	private int staffnumber;
	private String staffname;
	private String trainingname;
	private String trainingcontext;
	private String trainingdate;
	private String trainingsite;
    
	public Training(int trainingid, int staffnumber, String staffname, String trainingname, String trainingcontext,
			String trainingdate, String trainingsite) {
		super();
		this.trainingid = trainingid;
		this.staffnumber = staffnumber;
		this.staffname = staffname;
		this.trainingname = trainingname;
		this.trainingcontext = trainingcontext;
		this.trainingdate = trainingdate;
		this.trainingsite = trainingsite;
	}

	public Training() {
		
	}
    
	public String getStaffname() {
		return staffname;
	}

	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}

	public int getTrainingid() {
		return trainingid;
	}

	public void setTrainingid(int trainingid) {
		this.trainingid = trainingid;
	}

	public int getStaffnumber() {
		return staffnumber;
	}

	public void setStaffnumber(int staffnumber) {
		this.staffnumber = staffnumber;
	}

	public String getTrainingname() {
		return trainingname;
	}

	public void setTrainingname(String trainingname) {
		this.trainingname = trainingname;
	}

	public String getTrainingcontext() {
		return trainingcontext;
	}

	public void setTrainingcontext(String trainingcontext) {
		this.trainingcontext = trainingcontext;
	}

	public String getTrainingdate() {
		return trainingdate;
	}

	public void setTrainingdate(String trainingdate) {
		this.trainingdate = trainingdate;
	}

	public String getTrainingsite() {
		return trainingsite;
	}

	public void setTrainingsite(String trainingsite) {
		this.trainingsite = trainingsite;
	}

	@Override
	public String toString() {
		return "Training [trainingid=" + trainingid + ", staffnumber=" + staffnumber + ", staffname=" + staffname
				+ ", trainingname=" + trainingname + ", trainingcontext=" + trainingcontext + ", trainingdate="
				+ trainingdate + ", trainingsite=" + trainingsite + "]";
	}
	
	
}
