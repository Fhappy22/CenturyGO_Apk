package com.example.centurygo;

public class Appointment {
    private String date;
    private String time;
    private String description;
    private String fileUrl;

    public Appointment() {
        // Required empty constructor for Firestore
    }

    public Appointment(String date, String time, String description, String fileUrl) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.fileUrl = fileUrl;
    }

    // Getters and setters
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getFileUrl() { return fileUrl; }
    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }
}
