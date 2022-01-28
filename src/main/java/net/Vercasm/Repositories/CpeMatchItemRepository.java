package net.Vercasm.Repositories;

import net.Vercasm.nvd.CpeMatchItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CpeMatchItemRepository extends JpaRepository<CpeMatchItem, Long>{
    Optional<CpeMatchItem> findById(Long id);


}
