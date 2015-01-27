export DEBIAN_FRONTEND=noninteractive

# Always update, upgrade, cleanup
sudo apt-get update
apt-get -y dist-upgrade
apt-get -y autoremove

# We use this dir to keep track of the provisioning steps
readonly LOG_DIR='/var/log/vagrant/'
mkdir -p $LOG_DIR

if [ ! -f ${LOG_DIR}maven ];
then
    echo -e "\033[32m ==> Setting maven\033[00m"
    sudo apt-get install -y openjdk-7-jdk maven
    touch ${LOG_DIR}maven
fi

if [ ! -f ${LOG_DIR}firefox ];
then
    echo -e "\033[32m ==> Setting maven\033[00m"
    sudo apt-get install -y firefox xvfb
    touch ${LOG_DIR}firefox
fi
