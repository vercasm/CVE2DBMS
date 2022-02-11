package net.Vercasm.Controllers;

import lombok.AllArgsConstructor;
import net.Vercasm.Repositories.nvdCrudRepository;
import net.Vercasm.Services.nvdService;
import net.Vercasm.nvd.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping(path ="/api/v1")
@AllArgsConstructor
public class getData {

    @Autowired
    private nvdService jsService;


    @GetMapping(value = "/{id}")
    public Optional<String> findbyID(@PathVariable final Long id) {
        return Optional.ofNullable(jsService.getCVEbyID(1L).getCVEItems().stream().findFirst().get().getCve().getCVEDataMeta().getCve_id());
    }
    @PostMapping(value = "/pdata",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String addData(@RequestBody Root root){
        System.out.println("goodbye!");
       if( jsService.SaveData(root))
           return "true";
       else
           return "false";

    }
    @GetMapping(value ="/hello")
    public String helloWorld(){
        return "hello world";
    }
}
