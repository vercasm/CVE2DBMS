package net.Vercasm.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/status")
    public String public_test(){
        return "{'status' : 'up'}";
    }
}
/**
 * SELECT DISTINCT cve_name, CASE WHEN version3_base=NULL then version3_base=version2_base WHEN version2_base=NULL then version2_base=5.0 WHEN version2_base>0 AND version3_base>0 then version3_base=version3_base END, COALESCE(version3_base,5.0) as version3_base, configurations FROM verasm_data_raw WHERE ( configurations LIKE '%asfd%afsdas%'  AND configurations ~'cpe:2\.3:[o]:([\w]{0,40}):([\w]{0,40}):([a-z\d]{0,40})') OR ( configurations LIKE '%asfd:%' AND configurations ~ 'cpe:2\.3:[o]:([\w]{0,40}):([\w]{0,40}):\*:\*:\*:\*:\*:\*:\*:\*' ) OR (  configurations LIKE '%asfd%' AND ( version_start_including LIKE '%afsdas%' OR version_end_including LIKE '%afsdas%') AND configurations ~ 'cpe:2\.3:[o]:([\w]{0,40}):([\w]{0,40}):\*:\*:\*:\*:\*:\*:\*:\*' ) UNION SELECT DISTINCT cve_name, CASE WHEN version3_base=NULL then version3_base=version2_base WHEN version2_base=NULL then version2_base=5.0 WHEN version2_base>0 AND version3_base>0 then version3_base=version3_base END, COALESCE(version3_base,5.0) as version3_base, configurations FROM verasm_data_raw WHERE ( configurations LIKE '%framework%4.0%'  AND configurations ~'cpe:2\.3:[a]:([\w]{0,40}):([\w]{0,40}):([a-z\d]{0,40})') OR ( configurations LIKE '%framework:%' AND configurations ~ 'cpe:2\.3:[a]:([\w]{0,40}):([\w]{0,40}):\*:\*:\*:\*:\*:\*:\*:\*' ) OR (  configurations LIKE '%framework%' AND ( version_start_including LIKE '%4.0%' OR version_end_including LIKE '%4.0%') AND configurations ~ 'cpe:2\.3:[a]:([\w]{0,40}):([\w]{0,40}):\*:\*:\*:\*:\*:\*:\*:\*' )
 * 0.000000e+00 (0.92 seconds)
 * */