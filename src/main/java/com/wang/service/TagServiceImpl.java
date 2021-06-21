package com.wang.service;

import com.wang.NotFindException;
import com.wang.dao.TagRepository;
import com.wang.entity.Tags;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
@Service
public class TagServiceImpl implements TagService{
    @Autowired
    private TagRepository tagRepository;

    @Transactional
    @Override
    public Tags saveTags(Tags tags) {
        return tagRepository.save(tags);
    }

    @Transactional
    @Override
    public Tags getTagsById(Long id) {
        return tagRepository.getOne(id);
    }

    @Transactional
    @Override
    public Tags getTagsByName(String name) {
        return tagRepository.getTagsByName(name);
    }

    @Transactional
    @Override
    public Page<Tags> listTags(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }


    @Transactional
    @Override
    public List<Tags> listTags() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tags> listTags(String ids) {
        return tagRepository.findAllById(convertToList(ids));
    }

    @Override
    public List<Tags> listTagsTop(Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "blogs.size");
        Pageable pageable = PageRequest.of(0, size, sort);
        return tagRepository.findTagsTop(pageable);
    }

    private List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i=0; i < idarray.length;i++) {
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }

    @Transactional
    @Override
    public Tags updateTags(Long id, Tags tags) {
        Tags tags1 = tagRepository.getOne(id);
        if (tags1 == null) {
            throw new NotFindException("不存在该标签");
        }
        BeanUtils.copyProperties(tags, tags1);
        return tagRepository.save(tags1);
    }

    @Transactional
    @Override
    public void deleteTagsById(Long id) {
        tagRepository.deleteById(id);
    }
}
