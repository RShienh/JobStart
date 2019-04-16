package com.humber.jobstart.Models;

import com.google.firebase.firestore.Exclude;

/**
 * The type Jobs.
 * A Model class for Jobs
 */
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

    /**
     * Instantiates a new Jobs.
     */
    public Jobs() {
    }

    /**
     * Instantiates a new Jobs.
     *
     * @param id          the id
     * @param title       the title
     * @param postDate    the post date
     * @param applyDate   the apply date
     * @param type        the type
     * @param status      the status
     * @param description the description
     * @param location    the location
     * @param salary      the salary
     * @param contact     the contact
     */
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

    /**
     * Gets document id.
     *
     * @return the document id
     */
    @Exclude
    public String getDocumentID() {
        return documentID;
    }

    /**
     * Sets document id.
     *
     * @param documentID the document id
     */
    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets post date.
     *
     * @return the post date
     */
    public String getPostDate() {
        return postDate;
    }

    /**
     * Sets post date.
     *
     * @param postDate the post date
     */
    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    /**
     * Gets apply date.
     *
     * @return the apply date
     */
    public String getApplyDate() {
        return applyDate;
    }

    /**
     * Sets apply date.
     *
     * @param applyDate the apply date
     */
    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets salary.
     *
     * @return the salary
     */
    public String getSalary() {
        return salary;
    }

    /**
     * Sets salary.
     *
     * @param salary the salary
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * Gets contact.
     *
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets contact.
     *
     * @param contact the contact
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
