package com.zd.manager.business.model;

public class ProjectImages {
    private Integer projectImageId;

    private String thumbnailPath;

    private String originalPath;

    private Double originLength;

    private Double originWidth;

    private Double thumbnailLength;

    private Double thumbnailWidth;

    private String description;

    public Integer getProjectImageId() {
        return projectImageId;
    }

    public void setProjectImageId(Integer projectImageId) {
        this.projectImageId = projectImageId;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public String getOriginalPath() {
        return originalPath;
    }

    public void setOriginalPath(String originalPath) {
        this.originalPath = originalPath;
    }

    public Double getOriginLength() {
        return originLength;
    }

    public void setOriginLength(Double originLength) {
        this.originLength = originLength;
    }

    public Double getOriginWidth() {
        return originWidth;
    }

    public void setOriginWidth(Double originWidth) {
        this.originWidth = originWidth;
    }

    public Double getThumbnailLength() {
        return thumbnailLength;
    }

    public void setThumbnailLength(Double thumbnailLength) {
        this.thumbnailLength = thumbnailLength;
    }

    public Double getThumbnailWidth() {
        return thumbnailWidth;
    }

    public void setThumbnailWidth(Double thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}