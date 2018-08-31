package com.principal.uberization.userInfo.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserTypeEnum {
	USER("User",2), ADMIN("Admin",1);
	public static Map<String, UserTypeEnum> getNamesMap() {
		return namesMap;
	}

	public static void setNamesMap(Map<String, UserTypeEnum> namesMap) {
		UserTypeEnum.namesMap = namesMap;
	}
	private String name;
	private Integer id;
	
	private static Map<String, UserTypeEnum> namesMap = new HashMap<>(4);

    static {
        namesMap.put(USER.getName().toLowerCase(), USER);
        namesMap.put(ADMIN.getName().toLowerCase(), ADMIN);
    }

    @JsonCreator
    public static UserTypeEnum forValue(String value) {
        return namesMap.get(StringUtils.lowerCase(value));
    }

    @JsonValue
    public String toValue() {
        for (Entry<String, UserTypeEnum> entry : namesMap.entrySet()) {
            if (entry.getValue() == this)
                return entry.getValue().getName();
        }
        return null; 
    }
	
	public String getName() {
		return name;
	}
	public Integer getId() {
		return id;
	}
	private UserTypeEnum(String name, Integer id) {
		this.name = name;
		this.id = id;
	}
}
