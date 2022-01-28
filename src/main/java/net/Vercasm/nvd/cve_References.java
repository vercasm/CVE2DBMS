package net.Vercasm.nvd;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Entity
public class cve_References {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long refID;

	//@OneToMany(mappedBy = "reference_data_id", cascade={CascadeType.PERSIST})
	@ManyToMany( targetEntity = ReferenceDataItem.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "reference_data_item_id", referencedColumnName = "id")
	@JsonProperty("reference_data")
	private List<ReferenceDataItem> referenceData;



	public cve_References(List<ReferenceDataItem> referenceData) {
		this.referenceData = referenceData;
	}

	public void setReferenceData(List<ReferenceDataItem> referenceData){
		this.referenceData = referenceData;
	}

	public List<ReferenceDataItem> getReferenceData(){
		return referenceData;
	}

	@Override
 	public String toString(){
		return 
			"References{" + 
			"reference_data = '" + referenceData + '\'' + 
			"}";
		}
}