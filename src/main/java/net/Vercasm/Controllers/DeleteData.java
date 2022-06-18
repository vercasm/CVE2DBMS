package net.Vercasm.Controllers;

import net.Vercasm.Services.LocalDataService;
import net.Vercasm.Services.nvdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/delete")
public class DeleteData {

    public static Logger logger = LoggerFactory.getLogger(DeleteData.class);

    @Autowired
    private nvdService jsService;

    @Autowired
    private LocalDataService localDataService;

/**
 *  Deletes all  NormalizedCVE data from our local database
 * @return  Boolean if successful or not
 * */
@RequestMapping("/normalized")
    public  Boolean  DeleteCVEdata(){
        try{
            jsService.truncateRoot();
            if(jsService.getCVEbyID(1L) != null)
                throw new Exception("Failed to delete all objects");


        }catch (Exception e){
            logger.warn("Data did not delete: {}", e.getMessage());
            return  false;
        }
        logger.info("Deleted Normalization Success");
        return  true;
    }

    /**
     *  Deletes all  Non-NormalizedCVE data from our local database (big table)
     * @return  Boolean if successful or not
     * */
    @RequestMapping("/big-table")
    public  Boolean  DeleteBigCVEdata(){
        try{
          localDataService.DeleteTranslationTable();
            if(localDataService.TestExists(1L) != null)
                throw new Exception("Failed to delete all objects");

            return  true;
        }catch (Exception e){
            logger.warn("Data did not delete: {}", e.getMessage());
            return  false;
        }
    }
}
