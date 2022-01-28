package net.Vercasm.Repositories;

import net.Vercasm.nvd.CVEItemsItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CveItemsItemRepository extends JpaRepository<CVEItemsItem, Long> {
    Optional<CVEItemsItem> findById(Long id);
}
