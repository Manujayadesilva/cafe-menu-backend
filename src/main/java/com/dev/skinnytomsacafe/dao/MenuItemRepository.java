// src/main/java/com/dev/skinnytomsacafe/dao/MenuItemRepository.java
package com.dev.skinnytomsacafe.dao;

import com.dev.skinnytomsacafe.dto.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}