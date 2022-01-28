package net.Vercasm.nvd;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Entity
public class Problemtype{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long ID;

	@ManyToMany( targetEntity = ProblemtypeDataItem.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "problem_type_data_id", referencedColumnName = "id")
	@JsonProperty("problemtype_data")
	private List<ProblemtypeDataItem> problemtypeData;

	public Problemtype(List<ProblemtypeDataItem> problemtypeData) {
		this.problemtypeData = problemtypeData;
	}

	public void setProblemtypeData(List<ProblemtypeDataItem> problemtypeData){
		this.problemtypeData = problemtypeData;
	}

	public List<ProblemtypeDataItem> getProblemtypeData(){
		return problemtypeData;
	}

	@Override
 	public String toString(){
		return 
			"Problemtype{" + 
			"problemtype_data = '" + problemtypeData + '\'' + 
			"}";
		}
}