package com.zdjc.entity;

public class SectorImage {
    private Integer siId;

    private Integer sectorId;

    private Integer imageId;

    private Integer sectorImageType;

    private Integer imageType;

    public Integer getSiId() {
        return siId;
    }

    public void setSiId(Integer siId) {
        this.siId = siId;
    }

    public Integer getSectorId() {
        return sectorId;
    }

    public void setSectorId(Integer sectorId) {
        this.sectorId = sectorId;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getSectorImageType() {
        return sectorImageType;
    }

    public void setSectorImageType(Integer sectorImageType) {
        this.sectorImageType = sectorImageType;
    }

    public Integer getImageType() {
        return imageType;
    }

    public void setImageType(Integer imageType) {
        this.imageType = imageType;
    }
}