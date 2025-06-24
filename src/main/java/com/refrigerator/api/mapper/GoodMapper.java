package com.refrigerator.api.mapper;

import org.mapstruct.Mapper;

import com.refrigerator.api.dto.GoodDto;
import com.refrigerator.api.model.Good;

@Mapper(componentModel = "spring")
public interface GoodMapper {
    
	GoodDto toDto(Good good);
    
	Good toEntity(GoodDto dto);
}

