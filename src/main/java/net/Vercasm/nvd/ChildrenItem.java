package net.Vercasm.nvd;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Entity
public class ChildrenItem  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long ID;

    @ManyToMany( targetEntity = CpeMatchItem.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "CpeMatchItem_id", referencedColumnName = "id")
    @JsonProperty("cpe_match")
    private Set<CpeMatchItem> cpeMatch = new HashSet<CpeMatchItem>();

    @ManyToOne
    @JoinColumn(name = "parentTypeCode")
    protected ChildrenItem parent;
    //@JoinColumn(name = "child_leaf_Item_id", referencedColumnName = "id")
    @OneToMany(mappedBy = "parent")
    @JsonProperty("children")
    private  Set<ChildrenItem> children = new HashSet<ChildrenItem>();

    @JsonProperty("operator")
    private String operator;

    public void setCpeMatch(Set<CpeMatchItem> cpeMatch){
        this.cpeMatch = cpeMatch;
    }

    public Set<CpeMatchItem> getCpeMatch(){
        return cpeMatch;
    }

    public void setChildren(Set<ChildrenItem> children){
        this.children = children;
    }

    public Set<ChildrenItem> getChildren(){
        return children;
    }

    public void setOperator(String operator){
        this.operator = operator;
    }

    public String getOperator(){
        return operator;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    @Override
    public String toString(){
        return
                "NodesItem{" +
                        "cpe_match = '" + cpeMatch + '\'' +
                        ",children = '" + children + '\'' +
                        ",operator = '" + operator + '\'' +
                        "}";
    }
}
