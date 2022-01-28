package net.Vercasm.Repositories;

import net.Vercasm.nvd.CvssV2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CvssV2Repository extends JpaRepository<CvssV2, Long> {
    Optional<CvssV2> findById(Long id);
}