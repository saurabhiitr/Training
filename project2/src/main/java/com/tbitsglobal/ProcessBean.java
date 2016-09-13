package com.tbitsglobal;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "ProcessBean")
public class ProcessBean {
    private String id;
    private String name;
    private String address;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void show() {
        System.out.println(id);
        System.out.println(name);
        System.out.println(address);
    }
}