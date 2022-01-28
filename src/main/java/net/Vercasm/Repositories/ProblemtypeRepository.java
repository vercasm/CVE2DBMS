package net.Vercasm.Repositories;

import net.Vercasm.nvd.Problemtype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProblemtypeRepository extends JpaRepository<Problemtype, Long> {
    Optional<Problemtype> findById(Long id);
}
