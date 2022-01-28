package net.Vercasm.nvd;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CpeUri {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long ID;

    private String Title;

    private String cpeversion;

    private String part;

    private String vendor;

    private String product;

    private String version;

    private String update;

    private String edition;

    private String language;

    private String morefields;

   // @OneToMany(fetch = FetchType.LAZY, mappedBy = "cpe_uri")
 //   private List<CpeMatchItem> cmi = new ArrayList<>();

    public CpeUri(String information) {
        super();
        List alist = new ArrayList();
        StringTokenizer st = new StringTokenizer(information, ":");
        while(st.hasMoreTokens()){
            alist.add(st.nextToken());
        }
        this.setTitle(alist.get(0).toString());
        this.setCpeversion(alist.get(1).toString());
        this.setPart(alist.get(2).toString());
        this.setVendor(alist.get(3).toString());
        this.setProduct(alist.get(4).toString());
        this.setVersion(alist.get(5).toString());
        this.setUpdate(alist.get(6).toString());
        this.setEdition(alist.get(7).toString());
        this.setLanguage(alist.get(8).toString());
        this.setMorefields(alist.get(9).toString());

    }

    @Override
    public String toString() {
        return "CpeUri{" +
                "ID=" + ID +
                ", Title='" + Title + '\'' +
                ", cpeversion='" + cpeversion + '\'' +
                ", part='" + part + '\'' +
                ", vendor='" + vendor + '\'' +
                ", product='" + product + '\'' +
                ", version='" + version + '\'' +
                ", update='" + update + '\'' +
                ", edition='" + edition + '\'' +
                ", language='" + language + '\'' +
                ", morefields='" + morefields + '\'' +
                '}';
    }
}
