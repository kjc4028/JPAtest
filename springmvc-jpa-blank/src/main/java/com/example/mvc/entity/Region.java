package com.example.mvc.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "jc_region")
public class Region {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Integer regionId;
    @Column(name = "region_name")
    private String regionName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regionId", fetch = FetchType.LAZY)
    private List<City> cityList;

    public Region() {
    }

    public Region(Integer regionId) {
        this.regionId = regionId;
    }

    public Region(String regionName) {
        this.regionName = regionName;
    }

    public Region(Integer regionId, String regionName) {
        this.regionId = regionId;
        this.regionName = regionName;
    }

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", regionName=" + regionName + ", cityList=" + cityList + "]";
	}
    
    

}
