package net.Vercasm.nvd;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Entity
public class Impact{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "base_metricV2_id", referencedColumnName = "id")
	@JsonProperty("baseMetricV2")
	private BaseMetricV2 baseMetricV2;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "base_metricV3_id", referencedColumnName = "id")
	@JsonProperty("baseMetricV3")
	private BaseMetricV3 baseMetricV3;

	public Impact(BaseMetricV2 baseMetricV2,
				  BaseMetricV3 baseMetricV3) {
		this.baseMetricV2 = baseMetricV2;
		this.baseMetricV3 = baseMetricV3;
	}

	public void setBaseMetricV2(BaseMetricV2 baseMetricV2){
		this.baseMetricV2 = baseMetricV2;
	}

	public BaseMetricV2 getBaseMetricV2(){
		return baseMetricV2;
	}

	public void setBaseMetricV3(BaseMetricV3 baseMetricV3){
		this.baseMetricV3 = baseMetricV3;
	}

	public BaseMetricV3 getBaseMetricV3(){
		return baseMetricV3;
	}

	@Override
 	public String toString(){
		return 
			"Impact{" + 
			"baseMetricV2 = '" + baseMetricV2 + '\'' + 
			",baseMetricV3 = '" + baseMetricV3 + '\'' + 
			"}";
		}
}