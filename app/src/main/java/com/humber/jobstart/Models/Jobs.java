package com.humber.jobstart.Models;

import com.google.firebase.firestore.Exclude;

public class Jobs {
    private String id,
            title,
            postDate,
            applyDate,
            type,
            status,
            description,
            location,
            salary,
            contact,
            documentID;

    public Jobs() {
    }

    public Jobs(String id, String title, String postDate, String applyDate, String type, String status, String description, String location, String salary, String contact) {
        this.id = id;
        this.title = title;
        this.postDate = postDate;
        this.applyDate = applyDate;
        this.type = type;
        this.status = status;
        this.description = description;
        this.location = location;
        this.salary = salary;
        this.contact = contact;
    }

    @Exclude
    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
