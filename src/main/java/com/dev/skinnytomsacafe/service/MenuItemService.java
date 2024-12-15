// src/main/java/com/dev/skinnytomsacafe/service/MenuItemService.java
package com.dev.skinnytomsacafe.service;

import com.dev.skinnytomsacafe.dao.MenuItemRepository;
import com.dev.skinnytomsacafe.dto.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    public List<MenuItem> findAll() {
        return menuItemRepository.findAll();
    }

    public Optional<MenuItem> findById(Long id) {
        return menuItemRepository.findById(id);
    }

    public MenuItem save(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public void deleteById(Long id) {
        menuItemRepository.deleteById(id);
    }

    public Optional<MenuItem> updateMenuItem(Long id, MenuItem menuItemDetails) {
        return menuItemRepository.findById(id).map(menuItem -> {
            menuItem.setName(menuItemDetails.getName());
            menuItem.setIngredients(menuItemDetails.getIngredients());
            menuItem.setPrice(menuItemDetails.getPrice());
            menuItem.setImage(menuItemDetails.getImage());
            return menuItemRepository.save(menuItem);
        });
    }
}