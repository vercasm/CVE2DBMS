package net.Vercasm.nvd;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Embeddable
public class CVEDataMeta{
/*
	@SequenceGenerator(
			name = "CVEDataMeta_sequence",
			sequenceName = "CVEDataMeta_sequence",
			allocationSize = 1
	)
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "CVEDataMeta_sequence"
	)
	private Long MetaTable_ID;
*/
	@JsonProperty("ASSIGNER")
	private String aSSIGNER;

	@JsonProperty("ID")
	private String cve_id;

	public CVEDataMeta(String aSSIGNER,
					   String cve_id) {
		this.aSSIGNER = aSSIGNER;
		this.cve_id = cve_id;
	}

	public void setASSIGNER(String aSSIGNER){
		this.aSSIGNER = aSSIGNER;
	}

	public String getASSIGNER(){
		return aSSIGNER;
	}

	public void setCve_id(String iD){
		this.cve_id = iD;
	}

	public String getCve_id(){
		return cve_id;
	}

	@Override
 	public String toString(){
		return 
			"CVEDataMeta{" + 
			"aSSIGNER = '" + aSSIGNER + '\'' + 
			",iD = '" + cve_id + '\'' +
			"}";
		}
}