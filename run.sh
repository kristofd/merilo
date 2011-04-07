
rm reports/*
rm crawler/crawler.log

cd crawler
. ./run.sh
cd ..

cd htmlvalidator
. ./run.sh
cd ..

cd contenttests
. ./run.sh
cd ..

cd parentpages
. ./run.sh
cd ..

cd responsetimegraph
. ./run.sh
cd ..


. ./report.sh
