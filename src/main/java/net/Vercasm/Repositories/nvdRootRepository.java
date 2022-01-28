package net.Vercasm.Repositories;

import net.Vercasm.nvd.Root;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface nvdRootRepository extends JpaRepository<Root, Long> {

    Optional<Root> findByID(Long id);


}
