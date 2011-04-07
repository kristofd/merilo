
class ResponseTimeGraphGenerator {

	def responseTimeMap = new HashMap();

	def setInput(responseTimeList) {
		responseTimeList.eachLine {
			def time = it.split(' ')[0]
			def url = it.split(' ')[1]
			responseTimeMap[url] = time
		}
	}

	def writeJavaScript() {
		println "var responsetimeseries = { \ncolor: \"#000000\",\ndata: ["
	
		def counter = 1;
		responseTimeMap.each { key, value ->
			println "[" + counter + "," + value + "],"
			counter++;
		}
		println "]} \n \nvar urls = \n["

		responseTimeMap.each { key, value ->
			println "\"" + key + "\"" + ","
		}
		println "]\n"
		
	}
}

if (this.args.length < 1) {
	println "ResponseTime: Usage error."
} else {
	def p = new ResponseTimeGraphGenerator()
	p.setInput(new File(this.args[0]).getText())
	p.writeJavaScript()
}