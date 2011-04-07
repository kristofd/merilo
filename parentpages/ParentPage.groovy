
class ParentPageGenerator {

	def parentMap = new HashMap();

	def setInput(parentPageList) {
		parentPageList.eachLine {
			def to = it.split(' ')[0]
			def from = it.split(' ')[1]
			parentMap[to] = from
		}
	}

	def addParentPage(inputText) {
		inputText.eachLine {
			def url = it.split(' ')[1]
			println it + parentMap[url]
		}
	}
}


if (this.args.length < 2) {
        println "ParentPage: Usage error."
} else {
        def p = new ParentPageGenerator()
        p.setInput(new File(this.args[0]).getText())
		p.addParentPage(new File(this.args[1]).getText())
}