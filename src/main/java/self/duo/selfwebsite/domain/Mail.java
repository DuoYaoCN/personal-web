package self.duo.selfwebsite.domain;

import java.io.Serializable;

public final class Mail implements Serializable {
    private String username; //存储用户发送邮件的昵称
    private String address; //存储用户邮箱地址
    private String domain; //存储用户邮件主题
    private String summary; //存储用户发送邮件的摘要(上限 255 bite = 125 Chinese words)
    private String sendTo; //收件地址
    private String sendFrom; //发件人


    public Mail(String username, String address, String domain, String summary){
        this.sendTo = "duoyao790@gmail.com";
        this.sendFrom = "634479812@qq.com";
        this.username = username;
        this.address = address;
        this.domain = domain;
        this.summary = summary;
    }

    public String getSendFrom() {
        return sendFrom;
    }

    public void setSendFrom(String sendFrom) {
        this.sendFrom = sendFrom;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
