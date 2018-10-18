FROM payara/server-full:5.183
COPY target/microprofile.war $DEPLOY_DIR