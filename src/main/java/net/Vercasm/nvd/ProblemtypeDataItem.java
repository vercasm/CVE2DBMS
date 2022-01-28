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
public class ProblemtypeDataItem{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long ID;
//	@JoinColumn(name = "Description_Item_id", referencedColumnName = "id")
	@ManyToMany( targetEntity = DescriptionItem.class, cascade = CascadeType.ALL)
	@JsonProperty("description")
	private Set<DescriptionItem> description = new HashSet<DescriptionItem>();

	public ProblemtypeDataItem(Set<DescriptionItem> description) {
		this.description = description;
	}

	public void setDescription(Set<DescriptionItem> description){
		this.description = description;
	}

	public Set<DescriptionItem> getDescription(){
		return description;
	}

	@Override
 	public String toString(){
		return 
			"ProblemtypeDataItem{" + 
			"description = '" + description + '\'' + 
			"}";
		}
}