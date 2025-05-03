package icet.edu.repository;

import icet.edu.entity.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItemEntity, String> {
    List<MenuItemEntity> findByCategoryIgnoreCase(String category);
    List<MenuItemEntity> findByItemNameContainingIgnoreCase(String name);
    List<MenuItemEntity> findByItemCodeContainingIgnoreCase(String name);
}
