package net.Vercasm.Repositories;

import net.Vercasm.nvd.Cve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CveRepository extends JpaRepository<Cve, Long>{
    Optional<Cve> findById(Long id);
}
