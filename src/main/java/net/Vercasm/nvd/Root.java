package net.Vercasm.nvd;

import java.util.ArrayList;
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
public class Root{

	/*@SequenceGenerator(
			name = "Root_sequence",
			sequenceName = "Root_sequence",
			allocationSize = 1
	)
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "Root_sequence"
	)*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long ID;

  // SELECT * FROM ROOT;
  //
  @ManyToMany(targetEntity = CVEItemsItem.class, cascade = CascadeType.ALL)
  @JoinTable(
      name = "root_cveItems",
      joinColumns = {
      		@JoinColumn(name = "rootID", referencedColumnName = "id")},
      inverseJoinColumns = {
      		@JoinColumn( name = "cve_items_id", referencedColumnName = "id")
      })
  @JsonProperty("CVE_Items")
  private Set<CVEItemsItem> cVEItems = new HashSet<CVEItemsItem>();

	@JsonProperty("CVE_data_type")
	private String cVEDataType;

	@JsonProperty("CVE_data_format")
	private String cVEDataFormat;

	@JsonProperty("CVE_data_timestamp")
	private String cVEDataTimestamp;

	@JsonProperty("CVE_data_numberOfCVEs")
	private String cVEDataNumberOfCVEs;

	@JsonProperty("CVE_data_version")
	private String cVEDataVersion;

	public Root(Set<CVEItemsItem> cVEItems,
				String cVEDataType,
				String cVEDataFormat,
				String cVEDataTimestamp,
				String cVEDataNumberOfCVEs,
				String cVEDataVersion) {
    System.out.println("*******************"+cVEDataNumberOfCVEs);
		this.cVEItems = cVEItems;
		this.cVEDataType = cVEDataType;
		this.cVEDataFormat = cVEDataFormat;
		this.cVEDataTimestamp = cVEDataTimestamp;
		this.cVEDataNumberOfCVEs = cVEDataNumberOfCVEs;
		this.cVEDataVersion = cVEDataVersion;
	}

	public void setCVEItems(Set<CVEItemsItem> cVEItems){
		this.cVEItems = cVEItems;
	}

	public Set<CVEItemsItem> getCVEItems(){
		return cVEItems;
	}

	public void setCVEDataType(String cVEDataType){
		this.cVEDataType = cVEDataType;
	}

	public String getCVEDataType(){
		return cVEDataType;
	}

	public void setCVEDataFormat(String cVEDataFormat){
		this.cVEDataFormat = cVEDataFormat;
	}

	public String getCVEDataFormat(){
		return cVEDataFormat;
	}

	public void setCVEDataTimestamp(String cVEDataTimestamp){
		this.cVEDataTimestamp = cVEDataTimestamp;
	}

	public String getCVEDataTimestamp(){
		return cVEDataTimestamp;
	}

	public void setCVEDataNumberOfCVEs(String cVEDataNumberOfCVEs){
		System.out.println("*******************"+cVEDataNumberOfCVEs);
		this.cVEDataNumberOfCVEs = cVEDataNumberOfCVEs;
	}

	public String getCVEDataNumberOfCVEs(){
		return cVEDataNumberOfCVEs;
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
			"Root{" + 
			"cVE_Items = '" + cVEItems + '\'' + 
			",cVE_data_type = '" + cVEDataType + '\'' + 
			",cVE_data_format = '" + cVEDataFormat + '\'' + 
			",cVE_data_timestamp = '" + cVEDataTimestamp + '\'' + 
			",cVE_data_numberOfCVEs = '" + cVEDataNumberOfCVEs + '\'' + 
			",cVE_data_version = '" + cVEDataVersion + '\'' + 
			"}";
		}
}