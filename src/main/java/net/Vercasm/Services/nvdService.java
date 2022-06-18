package net.Vercasm.Services;

import lombok.AllArgsConstructor;

import net.Vercasm.Repositories.CveItemsItemRepository;
import net.Vercasm.Repositories.CveRepository;
import net.Vercasm.Repositories.nvdCrudRepository;
import net.Vercasm.Repositories.nvdRootRepository;
import net.Vercasm.nvd.Root;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;


@Service
@AllArgsConstructor
public class nvdService {


    private final static String ID_NOT_FOUND_MSG =
            "CVE DATA WTH ID: %s NOT FOUND!";



    @Autowired
    private nvdRootRepository nvdRootRepository;

    /*
    @Autowired
    private CveRepository cveRepository;

    @Autowired
    private CveItemsItemRepository cveItemsItemRepository;

    @Autowired
    private nvdCrudRepository nvdcrudrepo;
*/

    public Boolean SaveData(Root root){
        Root r = nvdRootRepository.save(root);

               if(r != null) {
                    r = null;
                    root = null;
                    System.gc();//calling the garbage collector.
                   return true;
               }
               else{
                   return false;
               }

    }

    public Root getCVEbyID(Long id){
        return nvdRootRepository.findByID(id)
                .orElseThrow(() -> new IllegalStateException(
                        String.format(ID_NOT_FOUND_MSG, id)));
    }
    public boolean isCVEbyID_present(Long id){
     return nvdRootRepository.findByID(id).isPresent();

    }

    public void save(Root root) {
    }

    public  void DeleteALL(){
        nvdRootRepository.deleteAll();
    }

    @Transactional
    public void truncateRoot(){
        nvdRootRepository.truncateRoot();
    }
}
