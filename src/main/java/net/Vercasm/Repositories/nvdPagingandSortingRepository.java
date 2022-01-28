package net.Vercasm.Repositories;

import net.Vercasm.nvd.Root;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface nvdPagingandSortingRepository extends PagingAndSortingRepository<Root, Long> {



}
