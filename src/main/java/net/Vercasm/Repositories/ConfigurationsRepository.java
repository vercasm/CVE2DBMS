package net.Vercasm.Repositories;

import net.Vercasm.nvd.Configurations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfigurationsRepository extends JpaRepository<Configurations, Long>{
    Optional<Configurations> findById(Long id);
}
