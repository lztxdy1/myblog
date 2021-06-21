package com.wang.dao;

import com.wang.entity.Tags;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepository extends JpaRepository<Tags, Long> {
    Tags getTagsByName(String name);

    @Query("select t from t_tags t")
    List<Tags> findTagsTop(Pageable pageable);
}
