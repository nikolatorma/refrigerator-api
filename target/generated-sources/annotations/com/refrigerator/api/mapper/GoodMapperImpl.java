package com.refrigerator.api.mapper;

import com.refrigerator.api.dto.GoodDto;
import com.refrigerator.api.model.Good;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-23T20:54:43+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class GoodMapperImpl implements GoodMapper {

    @Override
    public GoodDto toDto(Good good) {
        if ( good == null ) {
            return null;
        }

        GoodDto goodDto = new GoodDto();

        goodDto.setId( good.getId() );
        goodDto.setName( good.getName() );
        goodDto.setIcon( good.getIcon() );
        goodDto.setCategoryId( good.getCategoryId() );

        return goodDto;
    }

    @Override
    public Good toEntity(GoodDto dto) {
        if ( dto == null ) {
            return null;
        }

        Good good = new Good();

        good.setId( dto.getId() );
        good.setName( dto.getName() );
        good.setIcon( dto.getIcon() );
        good.setCategoryId( dto.getCategoryId() );

        return good;
    }
}
