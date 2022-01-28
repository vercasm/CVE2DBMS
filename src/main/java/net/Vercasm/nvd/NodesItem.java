package net.Vercasm.nvd;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Entity
public class NodesItem{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long ID;

	@ManyToMany( targetEntity = CpeMatchItem.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "CpeMatchItem_id", referencedColumnName = "id")
	@JsonProperty("cpe_match")
	private Set<CpeMatchItem> cpeMatch = new HashSet<CpeMatchItem>();
//@JoinColumn(name = "Nodes_Item_id", referencedColumnName = "id")
	//@ManyToOne( targetEntity = NodesItem.class, cascade = CascadeType.ALL)
	@ManyToMany(targetEntity = ChildrenItem.class, cascade = CascadeType.ALL)
	@JsonProperty("children")
	private Set<ChildrenItem> children = new HashSet<ChildrenItem>();

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