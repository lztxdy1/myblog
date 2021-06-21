package com.wang.service;

import com.wang.entity.Tags;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {
    Tags saveTags(Tags tags);
    Tags getTagsById(Long id);
    Tags getTagsByName(String name);
    Page<Tags> listTags(Pageable pageable);
    List<Tags> listTags();
    List<Tags> listTags(String ids);
    List<Tags> listTagsTop(Integer size);
    Tags updateTags(Long id, Tags tags);
    void deleteTagsById(Long id);
}
