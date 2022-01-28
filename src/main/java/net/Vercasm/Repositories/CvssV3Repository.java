package net.Vercasm.Repositories;


import net.Vercasm.nvd.CvssV3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CvssV3Repository extends JpaRepository<CvssV3, Long> {
    Optional<CvssV3> findById(Long id);
}
