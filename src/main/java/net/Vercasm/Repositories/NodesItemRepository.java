package net.Vercasm.Repositories;

import net.Vercasm.nvd.NodesItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NodesItemRepository extends JpaRepository<NodesItem, Long> {
    Optional<NodesItem> findById(Long id);
}
