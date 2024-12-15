// src/main/java/com/dev/skinnytomsacafe/dao/CategoryRepository.java
package com.dev.skinnytomsacafe.dao;

import com.dev.skinnytomsacafe.dto.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}