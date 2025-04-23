package icet.edu.service;

import icet.edu.dto.MenuItem;

import java.util.List;

public interface MenuItemService {
    void addMenuItem(MenuItem menuItem);
    List<MenuItem> getAllMenuItems();
    void deleteMenuItem(String itemCode);
    void updateMenuItem(MenuItem menuItem);
    List<MenuItem> getMenuItemsByCategory(String category);
    List<MenuItem> searchMenuItemsByName(String name);


    List<MenuItem> searchByItemCode(String name);
}
