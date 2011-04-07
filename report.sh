
touch reports/httperrors.txt

cat templates/header.html > reports/index.html

echo "<h2>Status</h2>" >> reports/index.html

timestamp=`date`
echo "Test finished at: $timestamp <br/>" >> reports/index.html
cat reports/crawlertime.txt >> reports/index.html
cat reports/pagecount.txt >> reports/index.html
cat reports/avgresponsetime.txt >> reports/index.html

echo "<h2><a name=\"htmlerrors\">HTML errors</a></h2>" >> reports/index.html
cat reports/htmlerrors.html >> reports/index.html

echo "<h2><a name=\"contenterrors\">Content errors</a></h2>" >> reports/index.html
cat reports/contenterrors.html >> reports/index.html

echo "<h2><a name=\"httperrors\">HTTP errors</a></h2>" >> reports/index.html
cat reports/httperrors_parents.txt | sed 's/http\(.*\) http\(.*\)/<a href=\"http\1\" target=\"_blank\">http\1<\/a> <a href=\"http\2\" target=\"_blank\">(parent page)<\/a><br\/> /' >> reports/index.html

echo "<h2><a name=\"responsetimes\">Top 20 response times</a></h2>" >> reports/index.html
cat reports/responsetimes_sorted.txt | head -20 | sed 's/http\(.*\) $/ms: <a href=\"http\1\" target=\"_blank\">http\1<\/a><br\/>/' >> reports/index.html

cp templates/jquery-1.5.2.min.js reports
cp templates/jquery.flot.min.js reports
cp templates/graph.js reports

cat templates/footer.html >> reports/index.html
