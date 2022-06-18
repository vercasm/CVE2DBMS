package net.Vercasm.Models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "cve_data")
@Subselect(
    "SELECT "
        + "         cve.id as id,  cve.cve_id as cve_id, description_data_item.value as description, "
        + "        cpe_uri.product as product, cvssv3.base_score as v3Base_score, cvssv2.base_score  as v2base_score, cpe_match_item.version_end_excluding as version_end_excluding, "
        + "        cpe_match_item.version_end_including as version_end_including, cpe_match_item.version_start_including as version_start_including, cpe_match_item.version_start_excluding as version_start_excluding, "
        + "         cpe_uri.edition as edition, cpe_uri.morefields as morefields, cpe_uri.part as part, cpe_uri.update as cupdate,  "
        + "         cpe_uri.vendor as vendor, cpe_uri.version as cversion"
        + "            FROM cveitems_item"
        + "             FULL JOIN cve"
        + "            ON (cveitems_item.cvedata_id = cve.id)"
        + "            INNER JOIN description"
        + "            ON (cve.description_id = description.id)"
        + "            INNER JOIN description_description_data"
        + "            ON (description.id = description_description_data.description_id)"
        + "            INNER JOIN description_data_item "
        + "            ON (description_description_data.description_data_id = description_data_item.id)"
        + "            INNER JOIN configurations"
        + "            ON (cveitems_item.conf_id = configurations.id)"
        + "            INNER JOIN configurations_nodes"
        + "            ON (configurations.id = configurations_nodes.config_id)"
        + "            INNER JOIN nodes_item"
        + "            ON (configurations_nodes.nodes_id = nodes_item.id)"
        + "            INNER JOIN nodes_item_cpe_match"
        + "            ON (nodes_item.id = nodes_item_cpe_match.nodes_item_id)"
        + "            INNER JOIN cpe_match_item"
        + "            ON (nodes_item_cpe_match.cpe_match_id = cpe_match_item.id)"
        + "            INNER JOIN cpe_uri"
        + "            ON (cpe_match_item.parent_type_cpe_uri = cpe_uri.id)"
        + "            INNER JOIN impact"
        + "            ON (cveitems_item.impact_id = impact.id)"
        + "            INNER JOIN base_metricv3"
        + "            ON (impact.base_metricv3_id = base_metricv3.id)"
        + "            INNER JOIN cvssv3"
        + "            ON (base_metricv3.cvssv3_id = cvssv3.id)"
        + "            INNER JOIN base_metricv2"
        + "            ON (impact.base_metricv2_id = base_metricv2.id)"
        + "            INNER JOIN cvssv2"
        + "            ON (base_metricv2.cvssv2_id = cvssv2.id)")
@Synchronize({"cveitems_item", "cveitems", "cve", "description", "description_description_data",
        "description_data_item" ,"configurations" ,"configurations_nodes" ,"nodes_item" ,
        "nodes_item_cpe_match", "cpe_uri", " impact" ,"base_metricv3", "cvssv3" ,"base_metricv2",
        "cvssv2"})
@Getter
@Setter
@Immutable
@NoArgsConstructor
@ToString
public class cveData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String cve_id;
    @Column(length = 8192)
    public String description;
    public String product;
    public Double v3base_score;
    public Double v2base_score;
    public String version_end_excluding;
    public String version_end_including;
    public String version_start_including;
    public String version_start_excluding;
    public String edition;
    public String morefields;
    public String part;
    public String cupdate;
    public String vendor;
    public String cversion;

    public cveData(Long id, String cve_id, String description, String product, Double v3base_score, Double v2base_score, String version_end_excluding, String version_end_including, String version_start_including, String version_start_excluding, String edition, String morefields, String part, String cupdate, String vendor, String cversion) {
        this.id = id;
        this.cve_id = cve_id;
        this.description = description;
        this.product = product;
        this.v3base_score = v3base_score;
        this.v2base_score = v2base_score;
        this.version_end_excluding = version_end_excluding;
        this.version_end_including = version_end_including;
        this.version_start_including = version_start_including;
        this.version_start_excluding = version_start_excluding;
        this.edition = edition;
        this.morefields = morefields;
        this.part = part;
        this.cupdate = cupdate;
        this.vendor = vendor;
        this.cversion = cversion;
    }
}
