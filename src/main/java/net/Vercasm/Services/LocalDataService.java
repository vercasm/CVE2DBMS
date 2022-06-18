package net.Vercasm.Services;

import net.Vercasm.Models.CveMainData;
import net.Vercasm.Models.cveData;

import net.Vercasm.Repositories.CveDataRepository;
import net.Vercasm.Repositories.CveMainDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocalDataService {
    public  static Logger logger = LoggerFactory.getLogger(LocalDataService.class);

    @Autowired
   private CveDataRepository cveDataRepository;

    @Autowired
    private CveMainDataRepository cveMainDataRepository;

    private final static String ID_NOT_FOUND_MSG =
            "CVE DATA WTH ID: %s NOT FOUND!";




    public cveData findbyId(Long id){
       if( cveDataRepository.findById(id).isPresent())
           return  cveDataRepository.findById(id).get();
       else
           return  null;
    }
    public void SaveAll(){


        Iterable<cveData> cv= cveDataRepository.findAll();
        logger.warn("saveAll - part: {}", cv.iterator().next().part.toLowerCase());
        cveDataRepository.saveAll(cv);

 // cveDataRepository.save(cveDat);
     //   cveDataRepository.
    }
    public  Iterable<cveData> findAll(){
        return cveDataRepository.findAll();
    }

    public  void SaveTranslation( Iterable<cveData> data){
        List<CveMainData> mainDataList = new ArrayList<>();

        for (cveData cdat :
                data) {

            mainDataList.add(new CveMainData(cdat.getId(), cdat.getCve_id(), cdat.getDescription(),
                    cdat.getProduct(), cdat.getV3base_score(), cdat.getV2base_score(), cdat.getVersion_end_excluding(),
                    cdat.getVersion_end_including(), cdat.getVersion_start_including(), cdat.getVersion_start_excluding(),
                    cdat.getEdition(), cdat.getMorefields(), cdat.getPart(), cdat.getCupdate(), cdat.getVendor(), cdat.getCversion()));
        }
        cveMainDataRepository.saveAll(mainDataList);
    }

    public  void DeleteTranslationTable(){
        cveMainDataRepository.deleteAll();
    }
    public  CveMainData TestExists(Long id){
        return  cveMainDataRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        String.format(ID_NOT_FOUND_MSG, id)));
    }
}
