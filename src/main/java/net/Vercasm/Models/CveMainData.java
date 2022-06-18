package net.Vercasm.Models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CveMainData {

    @Id
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


}
