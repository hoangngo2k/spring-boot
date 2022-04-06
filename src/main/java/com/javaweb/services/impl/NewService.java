package com.javaweb.services.impl;

import com.javaweb.convert.NewConvert;
import com.javaweb.dto.NewDTO;
import com.javaweb.entity.CategoryEntity;
import com.javaweb.entity.NewEntity;
import com.javaweb.repository.CategoryRepository;
import com.javaweb.repository.NewRepository;
import com.javaweb.services.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewService implements INewService {

    @Autowired
    private NewRepository newRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewConvert newConvert;

    @Override
    public NewDTO save(NewDTO news) {
        NewEntity newEntity = new NewEntity();
        if (news.getId() != null) {
            NewEntity oldNewEntity = newRepository.findOne(news.getId());
            newEntity = newConvert.toEntity(news, oldNewEntity);
        } else {
            newEntity = newConvert.toEntity(news);
        }
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(news.getCategoryCode());
        newEntity.setCategory(categoryEntity);
        newEntity = newRepository.save(newEntity);
        return newConvert.toDTO(newEntity);
    }

    @Override
    public void delete(long[] ids) {
        for (long item:ids) {
            newRepository.delete(item);
        }
    }

    @Override
    public List<NewDTO> findAll(Pageable pageable) {
        List<NewDTO> result = new ArrayList<>();
        List<NewEntity> entities = newRepository.findAll(pageable).getContent();
        for (NewEntity item:entities) {
            NewDTO newDTO = newConvert.toDTO(item);
            result.add(newDTO);
        }
        return result;
    }

    @Override
    public List<NewDTO> findAll() {
        List<NewDTO> result = new ArrayList<>();
        List<NewEntity> entities = newRepository.findAll();
        for (NewEntity item:entities) {
            NewDTO newDTO = newConvert.toDTO(item);
            result.add(newDTO);
        }
        return result;
    }

    @Override
    public int totalItems() {
        return (int) newRepository.count();
    }
}
