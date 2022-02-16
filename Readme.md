## Creates LOCAL DB for CVE data, and allows import

## Do not use directly unless you want to manually input data. 
## Debugging is done by jsonForce service. 


## Settings:

- Go to resources/application-prod.yml
    - copy this file to resources/application-dev.ym
    - insert passwords etc. for your machine.
    - dev.yml should be on gitignore. DO NOT CHANGE THIS (We don't need to know your passwords)
    - the ..-dev.yml is for your personal machine only!!!