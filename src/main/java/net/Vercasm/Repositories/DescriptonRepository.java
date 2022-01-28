package net.Vercasm.Repositories;

import net.Vercasm.nvd.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DescriptonRepository extends JpaRepository<Description, Long> {
    Optional<Description> findById(Long id);
}
