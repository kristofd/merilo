
class ResponseTimeSortedGraphGenerator {

	def responseTimeMap = new HashMap();

	def print(responseTimeList) {
		println "var responsetimeseries_sorted = { \ncolor: \"#000000\",\ndata: ["
		def counter = 1;

		responseTimeList.eachLine {
			def time = it.split(' ')[0]
			println "[" + counter + "," + time + "],"
			counter++;
		}
		println "]}\n"
	}
}

if (this.args.length < 1) {
	println "ResponseTimeSorted: Usage error."
} else {
	def p = new ResponseTimeSortedGraphGenerator()
	p.print(new File(this.args[0]).getText())
}