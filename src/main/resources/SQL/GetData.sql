
--RUN THIS TO GET MASTER TABLE
CREATE TABLE cve_out AS (
SELECT cve.id,  cve.cve_id, description_data_item.value as description, --configurations.id as configsID, cpe_uri.id as cpe_id, cveitems_item.cvedata_id,
        cpe_uri.product as product, cvssv3.base_score as v3Base_score, cvssv2.base_score as v2base_score, cpe_match_item.version_end_excluding,
        cpe_match_item.version_end_including, cpe_match_item.version_start_including, cpe_match_item.version_start_excluding,
         cpe_uri.edition, cpe_uri.morefields, cpe_uri.part, cpe_uri.update, cpe_uri.vendor, cpe_uri.version, coalesce(cvssv3.base_score, cvssv2.base_score) as coalesce_score
            FROM public.cveitems_item
            FULL JOIN cve
            ON cveitems_item.cvedata_id = cve.id
            INNER JOIN description
            ON cve.description_id = description.id
            INNER JOIN description_description_data
            ON description.id = description_description_data.description_id
            INNER JOIN description_data_item -- get description for all CVE's
            ON description_description_data.description_data_id = description_data_item.id
            INNER JOIN configurations -- Start line of joins to get CPE information
            ON cveitems_item.conf_id = configurations.id
            INNER JOIN configurations_nodes
            ON configurations.id = configurations_nodes.config_id
            INNER JOIN nodes_item
            ON configurations_nodes.nodes_id = nodes_item.id
            INNER JOIN nodes_item_cpe_match
            ON nodes_item.id = nodes_item_cpe_match.nodes_item_id
            INNER JOIN cpe_match_item
            ON nodes_item_cpe_match.cpe_match_id = cpe_match_item.id
            INNER JOIN cpe_uri
            ON cpe_match_item.parent_type_cpe_uri = cpe_uri.id
            INNER JOIN impact
            ON cveitems_item.impact_id = impact.id --start impact line of joins
            INNER JOIN base_metricv3 -- Version 3 CVSS first
            ON impact.base_metricv3_id = base_metricv3.id
            INNER JOIN cvssv3
            ON base_metricv3.cvssv3_id = cvssv3.id
            INNER JOIN base_metricv2 -- Version 2 CVSS now
            ON impact.base_metricv2_id = base_metricv2.id
            INNER JOIN cvssv2
            ON (base_metricv2.cvssv2_id = cvssv2.id)

)


