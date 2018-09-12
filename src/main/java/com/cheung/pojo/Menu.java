package com.cheung.pojo;


public class Menu {
    private String name;

    private Integer id;

    private String typeid;

    private String burden;

    private String brief;

    private String price;

    private String sums;

    private String price1;

    private String sums1;

    private String imgpath;

    private Type type;
    

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid == null ? null : typeid.trim();
    }

    public String getBurden() {
        return burden;
    }

    public void setBurden(String burden) {
        this.burden = burden == null ? null : burden.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getSums() {
        return sums;
    }

    public void setSums(String sums) {
        this.sums = sums == null ? null : sums.trim();
    }

    public String getPrice1() {
        return price1;
    }

    public void setPrice1(String price1) {
        this.price1 = price1 == null ? null : price1.trim();
    }

    public String getSums1() {
        return sums1;
    }

    public void setSums1(String sums1) {
        this.sums1 = sums1 == null ? null : sums1.trim();
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath == null ? null : imgpath.trim();
    }
}