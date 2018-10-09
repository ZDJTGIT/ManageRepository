package com.zd.manager.business.model;

public class ProjectImagesRelation {
    private Integer projectImagesRelationId;

    private Integer projectImagesId;

    private Integer projectId;

    private Integer imageType;

    public Integer getProjectImagesRelationId() {
        return projectImagesRelationId;
    }

    public void setProjectImagesRelationId(Integer projectImagesRelationId) {
        this.projectImagesRelationId = projectImagesRelationId;
    }

    public Integer getProjectImagesId() {
        return projectImagesId;
    }

    public void setProjectImagesId(Integer projectImagesId) {
        this.projectImagesId = projectImagesId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getImageType() {
        return imageType;
    }

    public void setImageType(Integer imageType) {
        this.imageType = imageType;
    }
}