package net.Vercasm.nvd;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Entity
public class BaseMetricV3{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@JsonProperty("exploitabilityScore")
	@Column(nullable = true)
	private double exploitabilityScore;

	@ManyToOne(cascade=CascadeType.ALL, targetEntity=CvssV3.class)
	@JoinColumn(nullable = true)
	@JsonProperty("cvssV3")
	private CvssV3 cvssV3;


	@JsonProperty("impactScore")
	private double impactScore;

	public BaseMetricV3(double exploitabilityScore,
						CvssV3 cvssV3,
						double impactScore) {
		this.exploitabilityScore = exploitabilityScore;
		this.cvssV3 = cvssV3;
		this.impactScore = impactScore;
	}

	public void setExploitabilityScore(double exploitabilityScore){
		this.exploitabilityScore = exploitabilityScore;
	}

	public double getExploitabilityScore(){
		return exploitabilityScore;
	}

	public void setCvssV3(CvssV3 cvssV3){
		this.cvssV3 = cvssV3;
	}

	public CvssV3 getCvssV3(){
		return cvssV3;
	}

	public void setImpactScore(double impactScore){
		this.impactScore = impactScore;
	}

	public double getImpactScore(){
		return impactScore;
	}

	@Override
 	public String toString(){
		return 
			"BaseMetricV3{" + 
			"exploitabilityScore = '" + exploitabilityScore + '\'' + 
			",cvssV3 = '" + cvssV3 + '\'' + 
			",impactScore = '" + impactScore + '\'' + 
			"}";
		}
}