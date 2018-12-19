package com.zdjc.entity;

public class SectorMember {
    private Integer seId;

    private Integer sectorId;

    private Integer memberId;

    private Integer sectorRole;

    public Integer getSeId() {
        return seId;
    }

    public void setSeId(Integer seId) {
        this.seId = seId;
    }

    public Integer getSectorId() {
        return sectorId;
    }

    public void setSectorId(Integer sectorId) {
        this.sectorId = sectorId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getSectorRole() {
        return sectorRole;
    }

    public void setSectorRole(Integer sectorRole) {
        this.sectorRole = sectorRole;
    }
}