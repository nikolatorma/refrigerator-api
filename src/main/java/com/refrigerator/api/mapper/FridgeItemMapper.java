package com.refrigerator.api.mapper;

import org.mapstruct.Mapper;

import com.refrigerator.api.dto.FridgeItemDto;
import com.refrigerator.api.model.FridgeItem;

@Mapper(componentModel = "spring", uses = {GoodMapper.class, UserMapper.class})
public interface FridgeItemMapper {
    
	FridgeItemDto toDto(FridgeItem fridgeItem);
    
	FridgeItem toEntity(FridgeItemDto dto);
}

