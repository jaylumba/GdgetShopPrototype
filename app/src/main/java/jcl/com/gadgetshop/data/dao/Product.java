package jcl.com.gadgetshop.data.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jayan on 3/6/2017.
 */
@Entity
public class Product {
    @Id(autoincrement = true) Long id;
    @Property int picResId;
    @Property String name;
    @Property double price;
    @Property String dateRelease;
    @Property String weight;
    @Property String os;
    @Property String storage;
    @Property String display;
    @Property String camera;
    @Property String ram;
    @Property String battery;
    @Property String category;
    @Generated(hash = 912444307)
    public Product(Long id, int picResId, String name, double price,
            String dateRelease, String weight, String os, String storage,
            String display, String camera, String ram, String battery,
            String category) {
        this.id = id;
        this.picResId = picResId;
        this.name = name;
        this.price = price;
        this.dateRelease = dateRelease;
        this.weight = weight;
        this.os = os;
        this.storage = storage;
        this.display = display;
        this.camera = camera;
        this.ram = ram;
        this.battery = battery;
        this.category = category;
    }
    @Generated(hash = 1890278724)
    public Product() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getPicResId() {
        return this.picResId;
    }
    public void setPicResId(int picResId) {
        this.picResId = picResId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getDateRelease() {
        return this.dateRelease;
    }
    public void setDateRelease(String dateRelease) {
        this.dateRelease = dateRelease;
    }
    public String getWeight() {
        return this.weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public String getOs() {
        return this.os;
    }
    public void setOs(String os) {
        this.os = os;
    }
    public String getStorage() {
        return this.storage;
    }
    public void setStorage(String storage) {
        this.storage = storage;
    }
    public String getDisplay() {
        return this.display;
    }
    public void setDisplay(String display) {
        this.display = display;
    }
    public String getCamera() {
        return this.camera;
    }
    public void setCamera(String camera) {
        this.camera = camera;
    }
    public String getRam() {
        return this.ram;
    }
    public void setRam(String ram) {
        this.ram = ram;
    }
    public String getBattery() {
        return this.battery;
    }
    public void setBattery(String battery) {
        this.battery = battery;
    }
    public String getCategory() {
        return this.category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
