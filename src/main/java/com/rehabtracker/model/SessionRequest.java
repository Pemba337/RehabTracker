package com.rehabtracker.model;

import java.time.LocalDate;

public class SessionRequest {
    private Long patientId;
    private Long therapistId;
    private LocalDate sessionDate;
    private String activityLogged;
    private String progressReport;
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Long getTherapistId() {
		return therapistId;
	}
	public void setTherapistId(Long therapistId) {
		this.therapistId = therapistId;
	}
	public LocalDate getSessionDate() {
		return sessionDate;
	}
	public void setSessionDate(LocalDate sessionDate) {
		this.sessionDate = sessionDate;
	}
	public String getActivityLogged() {
		return activityLogged;
	}
	public void setActivityLogged(String activityLogged) {
		this.activityLogged = activityLogged;
	}
	public String getProgressReport() {
		return progressReport;
	}
	public void setProgressReport(String progressReport) {
		this.progressReport = progressReport;
	}
    
}
