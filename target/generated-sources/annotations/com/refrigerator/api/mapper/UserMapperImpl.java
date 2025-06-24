package com.refrigerator.api.mapper;

import com.refrigerator.api.dto.UserDto;
import com.refrigerator.api.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-24T12:47:15+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User good) {
        if ( good == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( good.getId() );
        userDto.setUsername( good.getUsername() );
        userDto.setPassword( good.getPassword() );
        userDto.setEmail( good.getEmail() );
        userDto.setCreatedAt( good.getCreatedAt() );

        return userDto;
    }

    @Override
    public User toEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setUsername( dto.getUsername() );
        user.setPassword( dto.getPassword() );
        user.setEmail( dto.getEmail() );
        user.setCreatedAt( dto.getCreatedAt() );

        return user;
    }
}
