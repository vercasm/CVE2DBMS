package net.Vercasm.Repositories;

import net.Vercasm.nvd.cve_References;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface cve_ReferencesRepository extends JpaRepository<cve_References, Long> {
    Optional<cve_References> findById(Long id);
}
