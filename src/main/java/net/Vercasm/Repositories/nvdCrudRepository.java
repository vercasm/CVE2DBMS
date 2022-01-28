package net.Vercasm.Repositories;

import net.Vercasm.nvd.Root;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface nvdCrudRepository extends CrudRepository<Root, Long> {

}
// @JsonProperty