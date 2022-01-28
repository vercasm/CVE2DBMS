package net.Vercasm.nvd;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
public class CpeMatchItem{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long ID;

	@JsonProperty("vulnerable")
	private boolean vulnerable;

	@ManyToOne(cascade=CascadeType.ALL, targetEntity=CpeUri.class)
	@JoinColumn(name = "parentType_cpeUri")
	@JsonProperty("cpe23Uri")
	private CpeUri cpe23Uri = new CpeUri();
	//private String cpe23Uri;

	@ManyToOne
	@JoinColumn(name = "parentTypeCode")
	protected CpeMatchItem parent;

	@OneToMany(mappedBy = "parent")
	@JsonProperty("cpe_name")
	private Set<CpeMatchItem> cpeName = new HashSet<CpeMatchItem>();

	@JsonProperty("versionEndExcluding")
	private String versionEndExcluding;

	@JsonProperty("versionStartIncluding")
	private String versionStartIncluding;

	@JsonProperty("versionStartExcluding")
	private String versionStartExcluding;

	@JsonProperty("versionEndIncluding")
	private String versionEndIncluding;


	public CpeMatchItem(boolean vulnerable,
						CpeUri cpe23Uri,
						Set<CpeMatchItem> cpeName,
						String versionEndExcluding,
						String versionStartIncluding,
						String versionStartExcluding,
						String versionEndIncluding) {
		this.vulnerable = vulnerable;
		this.cpe23Uri = cpe23Uri;
		this.cpeName = cpeName;
		this.versionEndExcluding = versionEndExcluding;
		this.versionStartIncluding = versionStartIncluding;
		this.versionStartExcluding = versionStartExcluding;
		this.versionEndIncluding = versionEndIncluding;
	}

	public void setVulnerable(boolean vulnerable){
		this.vulnerable = vulnerable;
	}

	public boolean isVulnerable(){
		return vulnerable;
	}

	public void setCpe23Uri(CpeUri cpe23Uri){
		this.cpe23Uri = cpe23Uri;
	}

	public CpeUri getCpe23Uri(){
		return cpe23Uri;
	}

	public void setCpeName(Set<CpeMatchItem> cpeName){
		this.cpeName = cpeName;
	}

	public Set<CpeMatchItem> getCpeName(){
		return cpeName;
	}

	public String getVersionEndExcluding() {
		return versionEndExcluding;
	}

	public void setVersionEndExcluding(String versionEndExcluding) {
		this.versionEndExcluding = versionEndExcluding;
	}

	public String getVersionStartIncluding() {
		return versionStartIncluding;
	}

	public void setVersionStartIncluding(String versionStartIncluding) {
		this.versionStartIncluding = versionStartIncluding;
	}

	public String getVersionStartExcluding() {
		return versionStartExcluding;
	}

	public void setVersionStartExcluding(String versionStartExcluding) {
		this.versionStartExcluding = versionStartExcluding;
	}


}