package net.Vercasm.nvd;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cve")
public class Cve{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long ID;

	@JsonProperty("data_format")
	private String dataFormat;


	@OneToOne(targetEntity= cve_References.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "references_id", referencedColumnName = "refID")
	@JsonProperty("references")
	private cve_References cveReferences;

	@JsonProperty("data_version")
	private String dataVersion;

	@JsonProperty("data_type")
	private String dataType;

	@OneToOne(targetEntity=Description.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "description_id", referencedColumnName = "id")
	@JsonProperty("description")
	private Description description;

	@OneToOne(targetEntity=Problemtype.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "problemtype_id", referencedColumnName = "id")
	@JsonProperty("problemtype")
	private Problemtype problemtype;

	@Embedded
	@JsonProperty("CVE_data_meta")
	private CVEDataMeta cVEDataMeta;

	public Cve(String dataFormat,
			   cve_References cveReferences,
			   String dataVersion,
			   String dataType,
			   Description description,
			   Problemtype problemtype,
			   CVEDataMeta cVEDataMeta) {
		this.dataFormat = dataFormat;
		this.cveReferences = cveReferences;
		this.dataVersion = dataVersion;
		this.dataType = dataType;
		this.description = description;
		this.problemtype = problemtype;
		this.cVEDataMeta = cVEDataMeta;
	}

	public void setDataFormat(String dataFormat){
		this.dataFormat = dataFormat;
	}

	public String getDataFormat(){
		return dataFormat;
	}

	public void setCveReferences(cve_References cveReferences){
		this.cveReferences = cveReferences;
	}

	public cve_References getCveReferences(){
		return cveReferences;
	}

	public void setDataVersion(String dataVersion){
		this.dataVersion = dataVersion;
	}

	public String getDataVersion(){
		return dataVersion;
	}

	public void setDataType(String dataType){
		this.dataType = dataType;
	}

	public String getDataType(){
		return dataType;
	}

	public void setDescription(Description description){
		this.description = description;
	}

	public Description getDescription(){
		return description;
	}

	public void setProblemtype(Problemtype problemtype){
		this.problemtype = problemtype;
	}

	public Problemtype getProblemtype(){
		return problemtype;
	}

	public void setCVEDataMeta(CVEDataMeta cVEDataMeta){
		this.cVEDataMeta = cVEDataMeta;
	}

	public CVEDataMeta getCVEDataMeta(){
		return cVEDataMeta;
	}

	@Override
 	public String toString(){
		return 
			"Cve{" + 
			"data_format = '" + dataFormat + '\'' + 
			",references = '" + cveReferences + '\'' +
			",data_version = '" + dataVersion + '\'' + 
			",data_type = '" + dataType + '\'' + 
			",description = '" + description + '\'' + 
			",problemtype = '" + problemtype + '\'' + 
			",cVE_data_meta = '" + cVEDataMeta + '\'' + 
			"}";
		}
}