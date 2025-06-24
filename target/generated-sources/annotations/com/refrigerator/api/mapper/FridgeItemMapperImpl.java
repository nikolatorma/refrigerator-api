package com.refrigerator.api.mapper;

import com.refrigerator.api.dto.FridgeItemDto;
import com.refrigerator.api.model.FridgeItem;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-24T12:47:15+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class FridgeItemMapperImpl implements FridgeItemMapper {

    @Override
    public FridgeItemDto toDto(FridgeItem fridgeItem) {
        if ( fridgeItem == null ) {
            return null;
        }

        FridgeItemDto fridgeItemDto = new FridgeItemDto();

        fridgeItemDto.setId( fridgeItem.getId() );
        fridgeItemDto.setLocation( fridgeItem.getLocation() );
        if ( fridgeItem.getQuantity() != null ) {
            fridgeItemDto.setQuantity( fridgeItem.getQuantity() );
        }
        fridgeItemDto.setDateStored( fridgeItem.getDateStored() );
        fridgeItemDto.setBestBeforeDate( fridgeItem.getBestBeforeDate() );
        fridgeItemDto.setUserId( fridgeItem.getUserId() );
        fridgeItemDto.setGoodId( fridgeItem.getGoodId() );

        return fridgeItemDto;
    }

    @Override
    public FridgeItem toEntity(FridgeItemDto dto) {
        if ( dto == null ) {
            return null;
        }

        FridgeItem fridgeItem = new FridgeItem();

        fridgeItem.setId( dto.getId() );
        fridgeItem.setLocation( dto.getLocation() );
        fridgeItem.setQuantity( dto.getQuantity() );
        fridgeItem.setDateStored( dto.getDateStored() );
        fridgeItem.setBestBeforeDate( dto.getBestBeforeDate() );
        fridgeItem.setUserId( dto.getUserId() );
        fridgeItem.setGoodId( dto.getGoodId() );

        return fridgeItem;
    }
}
