package com.techragesh.springbootjpafileuploaddownloaddemo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "house")
public class FileUpload {

    @Id
    @Column(name = "house_id")
    private Long houseId;

    @Column(name = "house_name")
    private String houseName;

    @Column(name = "house_type")
    private String houseType;

    @Lob
    @Column(name = "house_images")
    private byte[] images;

    public FileUpload() {
    }

    public FileUpload(Long houseId, String houseName, String houseType, byte[] images) {
        this.houseId = houseId;
        this.houseName = houseName;
        this.houseType = houseType;
        this.images = images;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public byte[] getImages() {
        return images;
    }

    public void setImages(byte[] images) {
        this.images = images;
    }
}
