package net.Vercasm.Repositories;

import net.Vercasm.nvd.DescriptionDataItem;
import net.Vercasm.nvd.ReferenceDataItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DescriptionDataItemRepository extends JpaRepository<DescriptionDataItem, Long> {
    Optional<DescriptionDataItem> findById(Long id);
}
