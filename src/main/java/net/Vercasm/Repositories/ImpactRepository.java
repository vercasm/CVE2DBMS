package net.Vercasm.Repositories;

import net.Vercasm.nvd.Impact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImpactRepository extends JpaRepository<Impact, Long> {
    Optional<Impact> findById(Long id);
}
