package com.hz.business.base.pojo;

public class Sign {
    private Integer id;

    private String signRuleId;

    private Double latitude;

    private Double longitude;

    private String address;

    private String url;

    private Integer type;

    private String signTime;

    private String signPersonId;

    private String receiveId;

    private String groupId;
    
    private String signPersonName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSignRuleId() {
        return signRuleId;
    }

    public void setSignRuleId(String signRuleId) {
        this.signRuleId = signRuleId == null ? null : signRuleId.trim();
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime == null ? null : signTime.trim();
    }

    public String getSignPersonId() {
        return signPersonId;
    }

    public void setSignPersonId(String signPersonId) {
        this.signPersonId = signPersonId == null ? null : signPersonId.trim();
    }

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId == null ? null : receiveId.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

	public String getSignPersonName() {
		return signPersonName;
	}

	public void setSignPersonName(String signPersonName) {
		this.signPersonName = signPersonName;
	}
    
    
}