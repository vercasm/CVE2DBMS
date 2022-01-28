package net.Vercasm.Repositories;

import net.Vercasm.nvd.BaseMetricV3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BaseMetricV3Repository extends JpaRepository<BaseMetricV3, Long>{
    Optional<BaseMetricV3> findById(Long id);
}
