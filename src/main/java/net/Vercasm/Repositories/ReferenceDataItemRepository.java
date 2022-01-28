package net.Vercasm.Repositories;

import net.Vercasm.nvd.ReferenceDataItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReferenceDataItemRepository extends JpaRepository<ReferenceDataItem, Long> {
     Optional<ReferenceDataItem> findById(Long id);
     //Optional<> findById(Long id);
    // @Repository

    // extends JpaRepository< , Long>
}
