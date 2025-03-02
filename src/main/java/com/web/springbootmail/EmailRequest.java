package com.web.springbootmail;

import java.util.List;

public class EmailRequest {
    private String subject;
    private String content;
    private String to;
    private List<String> ccList;

    // Getters and Setters
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }

    public List<String> getCcList() { return ccList; }
    public void setCcList(List<String> ccList) { this.ccList = ccList; }
}
