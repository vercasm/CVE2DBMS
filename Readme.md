## Creates LOCAL DB for CVE data, and allows import

## Requirements:

- Java 17 or newer
- PostgreSQL 13 or newer
- Curl, Insomnia, or some other way of sending files via POST RESTful API requests
- Consul (For service discovery). THis service originally part of a much larger system that is private.


## Input CVE JSONS

- Go to the website here hosted by the National Vulnerability Database. Download each 'CVE-<YEAR>' Zip file.
[https://nvd.nist.gov/vuln/data-feeds#JSON_FEED](https://nvd.nist.gov/vuln/data-feeds#JSON_FEED)

- Unzip each JSON file then upload them to this service using post request

```
POST: <ip:port>/api/v1/pdata
```



## Development Setup:

- Go to resources/application-prod.yml
    - copy this file to resources/application-dev.ym
    - insert passwords etc. for your machine.
    - dev.yml should be on gitignore. DO NOT CHANGE THIS (We don't need to know your passwords)
    - the ..-dev.yml is for your personal machine only!!!
