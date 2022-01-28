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
public class Configurations{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long ID;

//@JoinColumn(name = "NodesItem_id", referencedColumnName = "id") //
	@ManyToMany(targetEntity =  NodesItem.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			name = "Configurations_Nodes",
			joinColumns = {
					@JoinColumn(name = "config_id", referencedColumnName = "id")},
			inverseJoinColumns = {
					@JoinColumn( name = "nodes_id", referencedColumnName = "id")
			})
	@JsonProperty("nodes")
	private Set<NodesItem> nodes = new HashSet<NodesItem>();

	@JsonProperty("CVE_data_version")
	private String cVEDataVersion;

	public Configurations(Set<NodesItem> nodes,
						  String cVEDataVersion) {
		this.nodes = nodes;
		this.cVEDataVersion = cVEDataVersion;
	}

	public void setNodes(Set<NodesItem> nodes){
		this.nodes = nodes;
	}

	public Set<NodesItem> getNodes(){
		return nodes;
	}

	public void setCVEDataVersion(String cVEDataVersion){
		this.cVEDataVersion = cVEDataVersion;
	}

	public String getCVEDataVersion(){
		return cVEDataVersion;
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
			"Configurations{" + 
			"nodes = '" + nodes + '\'' + 
			",cVE_data_version = '" + cVEDataVersion + '\'' + 
			"}";
		}
}