// src/main/java/com/dev/skinnytomsacafe/controller/MenuItemController.java
package com.dev.skinnytomsacafe.controller;

import com.dev.skinnytomsacafe.dto.MenuItem;
import com.dev.skinnytomsacafe.service.CategoryService;
import com.dev.skinnytomsacafe.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/menuitems")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;
    private CategoryService categoryService;

    @GetMapping
    public List<MenuItem> getAllMenuItems() {
        return menuItemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Long id) {
        Optional<MenuItem> menuItem = menuItemService.findById(id);
        return menuItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public MenuItem createMenuItem(
            @RequestParam("name") String name,
            @RequestParam("ingredients") String ingredients,
            @RequestParam("price") double price,
            @RequestParam("categoryId") Long categoryId,
            @RequestParam("image") MultipartFile image) throws IOException {

        MenuItem menuItem = new MenuItem();
        menuItem.setName(name);
        menuItem.setIngredients(ingredients);
        menuItem.setPrice(price);
        menuItem.setCategory(categoryService.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found")));
        menuItem.setImage(image.getBytes());

        return menuItemService.save(menuItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable Long id, @RequestBody MenuItem menuItemDetails) {
        Optional<MenuItem> menuItem = menuItemService.findById(id);
        if (menuItem.isPresent()) {
            MenuItem updatedMenuItem = menuItem.get();
            updatedMenuItem.setName(menuItemDetails.getName());
            updatedMenuItem.setIngredients(menuItemDetails.getIngredients());
            updatedMenuItem.setPrice(menuItemDetails.getPrice());
            updatedMenuItem.setImage(menuItemDetails.getImage());
            return ResponseEntity.ok(menuItemService.save(updatedMenuItem));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long id) {
        if (menuItemService.findById(id).isPresent()) {
            menuItemService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}