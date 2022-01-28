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
public class Description{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long ID;
//	@JoinColumn(name = "Description_Data_Item", referencedColumnName = "id")
	@ManyToMany( targetEntity = DescriptionDataItem.class, cascade = CascadeType.ALL)
	@JsonProperty("description_data")
	private Set<DescriptionDataItem> descriptionData = new HashSet<DescriptionDataItem>();

	public Description(Set<DescriptionDataItem> descriptionData) {
		this.descriptionData = descriptionData;
	}

	public void setDescriptionData(Set<DescriptionDataItem> descriptionData){
		this.descriptionData = descriptionData;
	}

	public Set<DescriptionDataItem> getDescriptionData(){
		return descriptionData;
	}

	@Override
 	public String toString(){
		return 
			"Description{" + 
			"description_data = '" + descriptionData + '\'' + 
			"}";
		}
}