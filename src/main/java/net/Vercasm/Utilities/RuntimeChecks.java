package net.Vercasm.Utilities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import net.Vercasm.Json2DbServiceApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Setter
@Getter
public class RuntimeChecks {

    private int cores_available;
    private Long mem_available;

    private final String NOT_ENOUGH_MEMORY = "Not enough Memory, please allocate more RAM!";
    private final String NOT_ENOUGH_CORES  = "Not enough cores, minimum 2 needed to run tasks!";

    public RuntimeChecks() {
       this.cores_available = Runtime.getRuntime().availableProcessors();
       this.mem_available = Runtime.getRuntime().freeMemory();
       if(cores_available <= 2) {
           System.out.println(NOT_ENOUGH_CORES);
           System.out.println("Available: "+ cores_available);
           
       }
       if ( mem_available <= 4096L)
       {
           System.out.println(NOT_ENOUGH_MEMORY);
           System.out.println("Available: "+ mem_available);
       }

    }
}
