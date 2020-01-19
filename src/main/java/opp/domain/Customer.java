package opp.domain;

import java.io.Serializable;

public class Customer implements Serializable {

    private long cus_id;
    private String cus_name;
    private String cus_source;
    private String cus_industry;
    private String cus_level;
    private String cus_address;
    private String cus_phone;

    public long getCus_id() {
        return cus_id;
    }

    public void setCus_id(long cus_id) {
        this.cus_id = cus_id;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getCus_source() {
        return cus_source;
    }

    public void setCus_source(String cus_source) {
        this.cus_source = cus_source;
    }

    public String getCus_industry() {
        return cus_industry;
    }

    public void setCus_industry(String cus_industry) {
        this.cus_industry = cus_industry;
    }

    public String getCus_level() {
        return cus_level;
    }

    public void setCus_level(String cus_level) {
        this.cus_level = cus_level;
    }

    public String getCus_address() {
        return cus_address;
    }

    public void setCus_address(String cus_address) {
        this.cus_address = cus_address;
    }

    public String getCus_phone() {
        return cus_phone;
    }

    public void setCus_phone(String cus_phone) {
        this.cus_phone = cus_phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cus_id=" + cus_id +
                ", cus_name='" + cus_name + '\'' +
                ", cus_source='" + cus_source + '\'' +
                ", cus_industry='" + cus_industry + '\'' +
                ", cus_level='" + cus_level + '\'' +
                ", cus_address='" + cus_address + '\'' +
                ", cus_phone='" + cus_phone + '\'' +
                '}';
    }
}
