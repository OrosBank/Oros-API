package org.apache.fineract.models;

import java.util.ArrayList;
import java.util.List;

public class Timeline {

    private List<Integer> submittedOnDate = new ArrayList<Integer>();
    private String submittedByUsername;
    private String submittedByFirstname;
    private String submittedByLastname;
    private List<Integer> activatedOnDate = new ArrayList<Integer>();
    private String activatedByUsername;
    private String activatedByFirstname;
    private String activatedByLastname;
    private List<Integer> closedOnDate = new ArrayList<Integer>();
    private String closedByUsername;
    private String closedByFirstname;
    private String closedByLastname;

    public Timeline() {
    }
    public String getSubmittedByUsername() {
        return this.submittedByUsername;
    }

    public void setSubmittedByUsername(String submittedByUsername) {
        this.submittedByUsername = submittedByUsername;
    }

    public String getSubmittedByFirstname() {
        return this.submittedByFirstname;
    }

    public void setSubmittedByFirstname(String submittedByFirstname) {
        this.submittedByFirstname = submittedByFirstname;
    }

    public String getSubmittedByLastname() {
        return this.submittedByLastname;
    }

    public void setSubmittedByLastname(String submittedByLastname) {
        this.submittedByLastname = submittedByLastname;
    }

    public String getActivatedByUsername() {
        return this.activatedByUsername;
    }

    public void setActivatedByUsername(String activatedByUsername) {
        this.activatedByUsername = activatedByUsername;
    }

    public String getActivatedByFirstname() {
        return this.activatedByFirstname;
    }

    public void setActivatedByFirstname(String activatedByFirstname) {
        this.activatedByFirstname = activatedByFirstname;
    }

    public String getActivatedByLastname() {
        return this.activatedByLastname;
    }

    public void setActivatedByLastname(String activatedByLastname) {
        this.activatedByLastname = activatedByLastname;
    }

    public List<Integer> getClosedOnDate() {
        return closedOnDate;
    }

    public void setClosedOnDate(List<Integer> closedOnDate) {
        this.closedOnDate = closedOnDate;
    }

    public String getClosedByUsername() {
        return closedByUsername;
    }

    public void setClosedByUsername(String closedByUsername) {
        this.closedByUsername = closedByUsername;
    }

    public String getClosedByFirstname() {
        return closedByFirstname;
    }

    public void setClosedByFirstname(String closedByFirstname) {
        this.closedByFirstname = closedByFirstname;
    }

    public String getClosedByLastname() {
        return closedByLastname;
    }

    public void setClosedByLastname(String closedByLastname) {
        this.closedByLastname = closedByLastname;
    }

    public List<Integer> getSubmittedOnDate() {
        return submittedOnDate;
    }

    public void setSubmittedOnDate(List<Integer> submittedOnDate) {
        this.submittedOnDate = submittedOnDate;
    }

    public List<Integer> getActivatedOnDate() {
        return activatedOnDate;
    }

    public void setActivatedOnDate(List<Integer> activatedOnDate) {
        this.activatedOnDate = activatedOnDate;
    }

}
