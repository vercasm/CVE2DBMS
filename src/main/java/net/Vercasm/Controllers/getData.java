package net.Vercasm.Controllers;

import lombok.AllArgsConstructor;
import net.Vercasm.Models.cveData;
import net.Vercasm.Repositories.nvdCrudRepository;
import net.Vercasm.Services.LocalDataService;
import net.Vercasm.Services.nvdService;
import net.Vercasm.nvd.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
@AllArgsConstructor
public class getData {

  @Autowired private nvdService jsService;

  @Autowired private LocalDataService localDataService;

  @GetMapping(value = "/{id}")
  public Optional<String> findbyID(@PathVariable final Long id) {
    return Optional.ofNullable(
        jsService.getCVEbyID(id).getCVEItems().stream()
            .findFirst()
            .get()
            .getCve()
            .getCVEDataMeta()
            .getCve_id());
  }

  @PostMapping(
      value = "/pdata",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String addData(@RequestBody Root root) {

    if (jsService.SaveData(root)) {
      root = null;
      System.gc();
      return "true";
    } else return "false";
  }
  @GetMapping("/save")
  public  String saveData(){
    //   localDataService.SaveAll();
    localDataService.SaveTranslation(localDataService.findAll());
    return "OK";

  }

  @GetMapping("/get-cve-by-id/{id}")
    public cveData getCVEbyID(Long id){
      return localDataService.findbyId(id);
  }
}
