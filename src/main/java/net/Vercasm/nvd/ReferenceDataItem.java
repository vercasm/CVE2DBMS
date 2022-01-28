package net.Vercasm.nvd;

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
public class ReferenceDataItem{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@Column(length=64000)
	@JsonProperty("refsource")
	private String refsource;

	@Column(length=64000)
	@JsonProperty("name")
	private String name;

	@Column(length=64000)
	@JsonProperty("url")
	private String url;

	//@ElementCollection(fetch = FetchType.LAZY)
//	@CollectionTable(name = "reference_tags", joinColumns = @JoinColumn(name = "id")) // 2
//	@Column(name = "reference_tags")
	//@JoinColumn(name = "tags_id", referencedColumnName = "id")
	@ElementCollection
	@JsonProperty("tags")
	private Set<String> tags = new HashSet<String>();

	public ReferenceDataItem(String refsource,
							 String name,
							 String url,
							 Set<String> tags) {
		this.refsource = refsource;
		this.name = name;
		this.url = url;
		this.tags = tags;
	}

	public void setRefsource(String refsource){
		this.refsource = refsource;
	}

	public String getRefsource(){
		return refsource;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setTags(Set<String> tags){
		this.tags = tags;
	}

	public Set<String> getTags(){
		return tags;
	}

	@Override
 	public String toString(){
		return 
			"ReferenceDataItem{" + 
			"refsource = '" + refsource + '\'' + 
			",name = '" + name + '\'' + 
			",url = '" + url + '\'' + 
			",tags = '" + tags + '\'' + 
			"}";
		}
}