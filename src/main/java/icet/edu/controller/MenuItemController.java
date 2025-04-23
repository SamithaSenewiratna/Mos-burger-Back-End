package icet.edu.controller;

import icet.edu.dto.MenuItem;
import icet.edu.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuItemService service;

    @PostMapping("/add")
    public void addMenuItem(@RequestBody MenuItem menuItem) {
        service.addMenuItem(menuItem);
    }

    @GetMapping("/all")
    public List<MenuItem> getAllMenuItems() {
        return service.getAllMenuItems();
    }

    @DeleteMapping("/delete/{itemCode}")
    public void deleteMenuItem(@PathVariable String itemCode) {

        service.deleteMenuItem(itemCode);
    }

    @PutMapping("/update{menuItem}")
    public void updateMenuItem(@RequestBody MenuItem menuItem) {
        service.updateMenuItem(menuItem);
    }

    @GetMapping("/category/{category}")
    public List<MenuItem> getMenuItemsByCategory(@PathVariable String category) {
        return service.getMenuItemsByCategory(category);
    }

    @GetMapping("/search/{name}")
    public List<MenuItem> searchMenuItems(@PathVariable String name) {
        return service.searchMenuItemsByName(name);
    }

    @GetMapping("/searchByItemCode/{itemCode}")
    public List<MenuItem> searchByItemCode(@PathVariable String itemCode) {

        return service.searchByItemCode(itemCode);
    }

}
