package net.Vercasm.nvd;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Entity
public class BaseMetricV2{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@JsonProperty("severity")
	private String severity;

	@JsonProperty("exploitabilityScore")
	private double exploitabilityScore;

	@JsonProperty("obtainAllPrivilege")
	private boolean obtainAllPrivilege;

	@JsonProperty("userInteractionRequired")
	private boolean userInteractionRequired;

	@JsonProperty("obtainOtherPrivilege")
	private boolean obtainOtherPrivilege;

	@ManyToOne(cascade=CascadeType.ALL, targetEntity=CvssV2.class)
	@JoinColumn
	@JsonProperty("cvssV2")
	private CvssV2 cvssV2;

	@JsonProperty("impactScore")
	private double impactScore;

	@JsonProperty("acInsufInfo")
	private boolean acInsufInfo;

	@JsonProperty("obtainUserPrivilege")
	private boolean obtainUserPrivilege;

	public BaseMetricV2(String severity,
						double exploitabilityScore,
						boolean obtainAllPrivilege,
						boolean userInteractionRequired,
						boolean obtainOtherPrivilege,
						CvssV2 cvssV2,
						double impactScore,
						boolean acInsufInfo,
						boolean obtainUserPrivilege) {
		this.severity = severity;
		this.exploitabilityScore = exploitabilityScore;
		this.obtainAllPrivilege = obtainAllPrivilege;
		this.userInteractionRequired = userInteractionRequired;
		this.obtainOtherPrivilege = obtainOtherPrivilege;
		this.cvssV2 = cvssV2;
		this.impactScore = impactScore;
		this.acInsufInfo = acInsufInfo;
		this.obtainUserPrivilege = obtainUserPrivilege;
	}

	public void setSeverity(String severity){
		this.severity = severity;
	}

	public String getSeverity(){
		return severity;
	}

	public void setExploitabilityScore(double exploitabilityScore){
		this.exploitabilityScore = exploitabilityScore;
	}

	public double getExploitabilityScore(){
		return exploitabilityScore;
	}

	public void setObtainAllPrivilege(boolean obtainAllPrivilege){
		this.obtainAllPrivilege = obtainAllPrivilege;
	}

	public boolean isObtainAllPrivilege(){
		return obtainAllPrivilege;
	}

	public void setUserInteractionRequired(boolean userInteractionRequired){
		this.userInteractionRequired = userInteractionRequired;
	}

	public boolean isUserInteractionRequired(){
		return userInteractionRequired;
	}

	public void setObtainOtherPrivilege(boolean obtainOtherPrivilege){
		this.obtainOtherPrivilege = obtainOtherPrivilege;
	}

	public boolean isObtainOtherPrivilege(){
		return obtainOtherPrivilege;
	}

	public void setCvssV2(CvssV2 cvssV2){
		this.cvssV2 = cvssV2;
	}

	public CvssV2 getCvssV2(){
		return cvssV2;
	}

	public void setImpactScore(double impactScore){
		this.impactScore = impactScore;
	}

	public double getImpactScore(){
		return impactScore;
	}

	public void setAcInsufInfo(boolean acInsufInfo){
		this.acInsufInfo = acInsufInfo;
	}

	public boolean isAcInsufInfo(){
		return acInsufInfo;
	}

	public void setObtainUserPrivilege(boolean obtainUserPrivilege){
		this.obtainUserPrivilege = obtainUserPrivilege;
	}

	public boolean isObtainUserPrivilege(){
		return obtainUserPrivilege;
	}

	@Override
 	public String toString(){
		return 
			"BaseMetricV2{" + 
			"severity = '" + severity + '\'' + 
			",exploitabilityScore = '" + exploitabilityScore + '\'' + 
			",obtainAllPrivilege = '" + obtainAllPrivilege + '\'' + 
			",userInteractionRequired = '" + userInteractionRequired + '\'' + 
			",obtainOtherPrivilege = '" + obtainOtherPrivilege + '\'' + 
			",cvssV2 = '" + cvssV2 + '\'' + 
			",impactScore = '" + impactScore + '\'' + 
			",acInsufInfo = '" + acInsufInfo + '\'' + 
			",obtainUserPrivilege = '" + obtainUserPrivilege + '\'' + 
			"}";
		}
}