package net.Vercasm.nvd;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Entity
public class DescriptionItem{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@JsonProperty("lang")
	private String lang;

	@JsonProperty("value")
	private String value;

	public DescriptionItem(String lang,
						   String value) {
		this.lang = lang;
		this.value = value;
	}

	public void setLang(String lang){
		this.lang = lang;
	}

	public String getLang(){
		return lang;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"DescriptionItem{" + 
			"lang = '" + lang + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}