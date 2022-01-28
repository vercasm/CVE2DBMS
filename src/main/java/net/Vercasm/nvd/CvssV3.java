package net.Vercasm.nvd;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Entity
public class CvssV3{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@JsonProperty("baseSeverity")
	private String baseSeverity;

	@JsonProperty("confidentialityImpact")
	private String confidentialityImpact;

	@JsonProperty("attackComplexity")
	private String attackComplexity;

	@JsonProperty("scope")
	private String scope;

	@JsonProperty("attackVector")
	private String attackVector;

	@JsonProperty("availabilityImpact")
	private String availabilityImpact;

	@JsonProperty("integrityImpact")
	private String integrityImpact;

	@JsonProperty("privilegesRequired")
	private String privilegesRequired;

	@JsonProperty("baseScore")
	private double baseScore;

	@JsonProperty("vectorString")
	private String vectorString;

	@JsonProperty("version")
	private String version;

	@JsonProperty("userInteraction")
	private String userInteraction;

	public CvssV3(String baseSeverity,
				  String confidentialityImpact,
				  String attackComplexity,
				  String scope,
				  String attackVector,
				  String availabilityImpact,
				  String integrityImpact,
				  String privilegesRequired,
				  double baseScore,
				  String vectorString,
				  String version,
				  String userInteraction) {
		this.baseSeverity = baseSeverity;
		this.confidentialityImpact = confidentialityImpact;
		this.attackComplexity = attackComplexity;
		this.scope = scope;
		this.attackVector = attackVector;
		this.availabilityImpact = availabilityImpact;
		this.integrityImpact = integrityImpact;
		this.privilegesRequired = privilegesRequired;
		this.baseScore = baseScore;
		this.vectorString = vectorString;
		this.version = version;
		this.userInteraction = userInteraction;
	}

	public void setBaseSeverity(String baseSeverity){
		this.baseSeverity = baseSeverity;
	}

	public String getBaseSeverity(){
		return baseSeverity;
	}

	public void setConfidentialityImpact(String confidentialityImpact){
		this.confidentialityImpact = confidentialityImpact;
	}

	public String getConfidentialityImpact(){
		return confidentialityImpact;
	}

	public void setAttackComplexity(String attackComplexity){
		this.attackComplexity = attackComplexity;
	}

	public String getAttackComplexity(){
		return attackComplexity;
	}

	public void setScope(String scope){
		this.scope = scope;
	}

	public String getScope(){
		return scope;
	}

	public void setAttackVector(String attackVector){
		this.attackVector = attackVector;
	}

	public String getAttackVector(){
		return attackVector;
	}

	public void setAvailabilityImpact(String availabilityImpact){
		this.availabilityImpact = availabilityImpact;
	}

	public String getAvailabilityImpact(){
		return availabilityImpact;
	}

	public void setIntegrityImpact(String integrityImpact){
		this.integrityImpact = integrityImpact;
	}

	public String getIntegrityImpact(){
		return integrityImpact;
	}

	public void setPrivilegesRequired(String privilegesRequired){
		this.privilegesRequired = privilegesRequired;
	}

	public String getPrivilegesRequired(){
		return privilegesRequired;
	}

	public void setBaseScore(double baseScore){
		this.baseScore = baseScore;
	}

	public double getBaseScore(){
		return baseScore;
	}

	public void setVectorString(String vectorString){
		this.vectorString = vectorString;
	}

	public String getVectorString(){
		return vectorString;
	}

	public void setVersion(String version){
		this.version = version;
	}

	public String getVersion(){
		return version;
	}

	public void setUserInteraction(String userInteraction){
		this.userInteraction = userInteraction;
	}

	public String getUserInteraction(){
		return userInteraction;
	}

	@Override
 	public String toString(){
		return 
			"CvssV3{" + 
			"baseSeverity = '" + baseSeverity + '\'' + 
			",confidentialityImpact = '" + confidentialityImpact + '\'' + 
			",attackComplexity = '" + attackComplexity + '\'' + 
			",scope = '" + scope + '\'' + 
			",attackVector = '" + attackVector + '\'' + 
			",availabilityImpact = '" + availabilityImpact + '\'' + 
			",integrityImpact = '" + integrityImpact + '\'' + 
			",privilegesRequired = '" + privilegesRequired + '\'' + 
			",baseScore = '" + baseScore + '\'' + 
			",vectorString = '" + vectorString + '\'' + 
			",version = '" + version + '\'' + 
			",userInteraction = '" + userInteraction + '\'' + 
			"}";
		}
}