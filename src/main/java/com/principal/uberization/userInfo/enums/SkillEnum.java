package com.principal.uberization.userInfo.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SkillEnum {
	DENTAL_CLAIM("Dental Claim","Dental Claim",2), VISION_CLAIM("Vision Claim","Vision Claim",1),
	DATA_ENTRY("Data Entry","Data Entry",4),MEDICAL_REVIEW("Medical Review","Medical Review",3),
	CASE_PROCESSING("Case Processing","Case Processing",5);
	private String name;
	private Integer id;
	private String description;
	
	public static Map<String, SkillEnum> namesMap = new HashMap<String, SkillEnum>(4);

    public static Map<String, SkillEnum> getNamesMap() {
		return namesMap;
	}
	static {
        namesMap.put(DENTAL_CLAIM.getName().toLowerCase(), DENTAL_CLAIM);
        namesMap.put(VISION_CLAIM.getName().toLowerCase(), VISION_CLAIM);
        namesMap.put(DATA_ENTRY.getName().toLowerCase(), DATA_ENTRY);
        namesMap.put(MEDICAL_REVIEW.getName().toLowerCase(), MEDICAL_REVIEW);
        namesMap.put(CASE_PROCESSING.getName().toLowerCase(), CASE_PROCESSING);
    }

    @JsonCreator
    public static SkillEnum forValue(String value) {
        return namesMap.get(StringUtils.lowerCase(value));
    }

    @JsonValue
    public String toValue() {
        for (Entry<String, SkillEnum> entry : namesMap.entrySet()) {
            if (entry.getValue() == this)
                return entry.getKey();
        }
        return null; // or fail
    }
    
    
	public String getDescription() {
		return description;
	}
	public String getName() {
		return name;
	}
	public Integer getId() {
		return id;
	}
	private SkillEnum(String name,String description, Integer id) {
		this.name = name;
		this.id = id;
		this.description=description;
	}
}
