package net.Vercasm.Repositories;

import net.Vercasm.nvd.Root;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface nvdRootRepository extends JpaRepository<Root, Long> {

    Optional<Root> findByID(Long id);
/**
 * Note: Cascade didn't go down from root like expected, so put ALL tables and truncate them all
 *  We need to add some auth to this in the future with Spring Security as this is quite vulnerable operation.
 *  
 * */
    @Modifying
    @Query(value = "TRUNCATE  root,  root_cve_items, CVEItems_Item, " +
            "cve, configurations, impact , base_metricv2, base_metricv3, children_item, " +
            "children_item_cpe_match, configurations_nodes, cpe_match_item, cpe_uri, " +
            "cve_references, cve_references_reference_data, cvssv2, cvssv3, description, " +
            "description_data_item, description_description_data, description_item, " +
            "nodes_item, nodes_item_children, nodes_item_cpe_match," +
            "problemtype, problemtype_data_item, problemtype_data_item_description," +
            "problemtype_problemtype_data, reference_data_item, reference_data_item_tags CASCADE", nativeQuery = true)
    void truncateRoot();


}
