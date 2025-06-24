package com.refrigerator.api.mapper;

import org.mapstruct.Mapper;

import com.refrigerator.api.dto.UserDto;
import com.refrigerator.api.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
	UserDto toDto(User good);
    
	User toEntity(UserDto dto);
}

