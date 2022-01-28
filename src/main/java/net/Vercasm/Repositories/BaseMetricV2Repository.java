package net.Vercasm.Repositories;

import net.Vercasm.nvd.BaseMetricV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BaseMetricV2Repository extends JpaRepository<BaseMetricV2, Long>{
    Optional<BaseMetricV2> findById(Long id);
}
