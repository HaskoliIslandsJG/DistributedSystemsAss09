Github repo : https://github.com/jeje42/HI-Distributed-Systems.git

Both cases : cd into the bin directory.

Server : launch rmiregistry

1. Start server using (adjust classpath parameter -cp to let it point to your directory that contains the ds_04 subdirectory that contain the *.class files)
java -cp ./ -Djava.rmi.server.codebase=file:///./ -Djava.security.policy=../policy.txt Server 

2. Start on same machine client using (adjust classpath)
java -cp ./  -Djava.security.policy=../policy.txt Client localhost
