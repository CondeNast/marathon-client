mvn versions:set -DnewVersion=0.5.1-cnpatch -DgenerateBackupPoms=false

mvn clean compile package deploy:deploy -DskipNexusStagingDeployMojo=true -DaltDeploymentRepository=nexus.conde.io-carmot-releases::default::http://nexus.conde.io/nexus/content/repositories/releases/
