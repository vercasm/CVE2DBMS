
package net.Vercasm.nvd;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CVEItemsItem{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long ID;


	@ManyToOne(cascade=CascadeType.ALL, targetEntity=Cve.class)
	@JoinColumn(name = "cvedata_id", referencedColumnName = "id")
	@JsonProperty("cve")
	private Cve cve;


	@JsonProperty("lastModifiedDate")
	private String lastModifiedDate;

	@ManyToOne(cascade=CascadeType.ALL, targetEntity=Configurations.class)
	@JoinColumn(name = "conf_id", referencedColumnName = "id")
	@JsonProperty("configurations")
	private Configurations configurations;

	@ManyToOne(cascade=CascadeType.ALL, targetEntity=Impact.class)
	@JoinColumn(name = "impact_id", referencedColumnName = "id")
	@JsonProperty("impact")
	private Impact impact;


	@JsonProperty("publishedDate")
	private String publishedDate;



	public CVEItemsItem(Cve cve,
						String lastModifiedDate,
						Configurations configurations,
						Impact impact,
						String publishedDate) {
		this.cve = cve;
		this.lastModifiedDate = lastModifiedDate;
		this.configurations = configurations;
		this.impact = impact;
		this.publishedDate = publishedDate;
	}

	public void setCve(Cve cve){
		this.cve = cve;
	}

	public Cve getCve(){
		return cve;
	}

	public void setLastModifiedDate(String lastModifiedDate){
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedDate(){
		return lastModifiedDate;
	}

	public void setConfigurations(Configurations configurations){
		this.configurations = configurations;
	}

	public Configurations getConfigurations(){
		return configurations;
	}

	public void setImpact(Impact impact){
		this.impact = impact;
	}

	public Impact getImpact(){
		return impact;
	}

	public void setPublishedDate(String publishedDate){
		this.publishedDate = publishedDate;
	}

	public String getPublishedDate(){
		return publishedDate;
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
			"CVEItemsItem{" + 
			"cve = '" + cve + '\'' + 
			",lastModifiedDate = '" + lastModifiedDate + '\'' + 
			",configurations = '" + configurations + '\'' + 
			",impact = '" + impact + '\'' + 
			",publishedDate = '" + publishedDate + '\'' + 
			"}";
		}


}