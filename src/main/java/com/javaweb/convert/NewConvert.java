package com.javaweb.convert;

import com.javaweb.dto.NewDTO;
import com.javaweb.entity.NewEntity;
import org.springframework.stereotype.Component;

@Component
public class NewConvert {

    public NewEntity toEntity(NewDTO newDTO) {
        NewEntity newEntity = new NewEntity();
        newEntity.setTitle(newDTO.getTitle());
        newEntity.setContent(newDTO.getContent());
        newEntity.setThumbnail(newDTO.getThumbnail());
        newEntity.setShortDescription(newDTO.getShortDescription());
        return newEntity;
    }

    public NewDTO toDTO(NewEntity entity) {
        NewDTO dto = new NewDTO();
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setShortDescription(entity.getShortDescription());
        dto.setThumbnail(entity.getThumbnail());
        dto.setCreatedDate(entity.getCreateDate());
        dto.setCreatedBy(entity.getCreateBy());
        dto.setModifiedDate(entity.getLastModifiedDate());
        dto.setModifiedBy(entity.getLastModifiedBy());
        return dto;
    }

    public NewEntity toEntity(NewDTO newDTO, NewEntity newEntity) {
        newEntity.setTitle(newDTO.getTitle());
        newEntity.setContent(newDTO.getContent());
        newEntity.setThumbnail(newDTO.getThumbnail());
        newEntity.setShortDescription(newDTO.getShortDescription());
        return newEntity;
    }
}
