package icet.edu.service.impl;

import icet.edu.dto.MenuItem;
import icet.edu.entity.MenuItemEntity;
import icet.edu.repository.MenuItemRepository;
import icet.edu.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository repository;
    private final ModelMapper mapper;

    @Override
    public void addMenuItem(MenuItem menuItem) {
        repository.save(mapper.map(menuItem, MenuItemEntity.class));
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        List<MenuItemEntity> allItems = repository.findAll();
        List<MenuItem> itemList = new ArrayList<>();

        allItems.forEach(entity -> {
            itemList.add(mapper.map(entity, MenuItem.class));
        });

        return itemList;
    }

    @Override
    public void deleteMenuItem(String itemCode) {
        if (repository.existsById(itemCode)) {
            repository.deleteById(itemCode);
        } else {
            throw new RuntimeException("Menu Item with code " + itemCode + " not found");
        }
    }

    @Override
    public void updateMenuItem(MenuItem menuItem) {
        Optional<MenuItemEntity> existingItem = repository.findById(menuItem.getItemCode());

        if (existingItem.isPresent()) {
            repository.save(mapper.map(menuItem, MenuItemEntity.class));
        } else {
            throw new RuntimeException("Menu Item not found for update!");
        }
    }

    @Override
    public List<MenuItem> getMenuItemsByCategory(String category) {
        List<MenuItemEntity> categoryItems = repository.findByCategoryIgnoreCase(category);
        List<MenuItem> itemList = new ArrayList<>();

        categoryItems.forEach(entity -> {
            itemList.add(mapper.map(entity, MenuItem.class));
        });

        return itemList;
    }

    @Override
    public List<MenuItem> searchMenuItemsByName(String name) {
        List<MenuItemEntity> searchResults = repository.findByItemNameContainingIgnoreCase(name);
        List<MenuItem> itemList = new ArrayList<>();

        searchResults.forEach(entity -> {
            itemList.add(mapper.map(entity, MenuItem.class));
        });

        return itemList;
    }

    @Override
    public List<MenuItem> searchByItemCode(String name) {
        List<MenuItemEntity> searchResults = repository.findByItemCodeContainingIgnoreCase(name);
        List<MenuItem> itemList = new ArrayList<>();

        searchResults.forEach(entity -> {
            itemList.add(mapper.map(entity, MenuItem.class));
        });

        return itemList;
    }


}
