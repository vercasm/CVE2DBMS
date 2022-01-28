package net.Vercasm.nvd;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Entity
public class CvssV2{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@JsonProperty("accessComplexity")
	private String accessComplexity;

	@JsonProperty("confidentialityImpact")
	private String confidentialityImpact;

	@JsonProperty("availabilityImpact")
	private String availabilityImpact;

	@JsonProperty("integrityImpact")
	private String integrityImpact;

	@JsonProperty("baseScore")
	private double baseScore;

	@JsonProperty("vectorString")
	private String vectorString;

	@JsonProperty("version")
	private String version;

	@JsonProperty("accessVector")
	private String accessVector;

	@JsonProperty("authentication")
	private String authentication;

	public CvssV2(String accessComplexity,
				  String confidentialityImpact,
				  String availabilityImpact,
				  String integrityImpact,
				  double baseScore,
				  String vectorString,
				  String version,
				  String accessVector,
				  String authentication) {
		this.accessComplexity = accessComplexity;
		this.confidentialityImpact = confidentialityImpact;
		this.availabilityImpact = availabilityImpact;
		this.integrityImpact = integrityImpact;
		this.baseScore = baseScore;
		this.vectorString = vectorString;
		this.version = version;
		this.accessVector = accessVector;
		this.authentication = authentication;
	}

	public void setAccessComplexity(String accessComplexity){
		this.accessComplexity = accessComplexity;
	}

	public String getAccessComplexity(){
		return accessComplexity;
	}

	public void setConfidentialityImpact(String confidentialityImpact){
		this.confidentialityImpact = confidentialityImpact;
	}

	public String getConfidentialityImpact(){
		return confidentialityImpact;
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

	public void setAccessVector(String accessVector){
		this.accessVector = accessVector;
	}

	public String getAccessVector(){
		return accessVector;
	}

	public void setAuthentication(String authentication){
		this.authentication = authentication;
	}

	public String getAuthentication(){
		return authentication;
	}

	@Override
 	public String toString(){
		return 
			"CvssV2{" + 
			"accessComplexity = '" + accessComplexity + '\'' + 
			",confidentialityImpact = '" + confidentialityImpact + '\'' + 
			",availabilityImpact = '" + availabilityImpact + '\'' + 
			",integrityImpact = '" + integrityImpact + '\'' + 
			",baseScore = '" + baseScore + '\'' + 
			",vectorString = '" + vectorString + '\'' + 
			",version = '" + version + '\'' + 
			",accessVector = '" + accessVector + '\'' + 
			",authentication = '" + authentication + '\'' + 
			"}";
		}
}