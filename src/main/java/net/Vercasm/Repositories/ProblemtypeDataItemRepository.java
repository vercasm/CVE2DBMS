package net.Vercasm.Repositories;

import net.Vercasm.nvd.ProblemtypeDataItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProblemtypeDataItemRepository extends JpaRepository<ProblemtypeDataItem, Long> {
    Optional<ProblemtypeDataItem> findById(Long id);
}
