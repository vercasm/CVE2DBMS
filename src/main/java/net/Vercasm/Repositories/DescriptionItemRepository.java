package net.Vercasm.Repositories;

import net.Vercasm.nvd.DescriptionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DescriptionItemRepository extends JpaRepository<DescriptionItem, Long> {
    Optional<DescriptionItem> findById(Long id);
}
