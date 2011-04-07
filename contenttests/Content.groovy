	
class ContentTester {

	def PAGE_ROOT = "../webpages/"

	def list() {
		new File(PAGE_ROOT).eachFileRecurse {
			if (it.isFile()) {
				String input = it.getText()

				String report = addError(input, "Erroneous date format:", "The date format was not correct.")

				if (report.length() > 0) {
					println convertPathToURL(it.path) + "\n<p>" + report + "\n</p>\n"
				}
			}
		}
	}

	def addError(source, errorText, errorMessage) {
		if (source.contains(errorText)) {
			return "\n" + errorMessage + " Page contains: " + errorText
		} else {
			return ""
		}
	}
	
	def convertPathToURL(path) {
		def url = path.replace(PAGE_ROOT, "")
		url = url.replace("\\", "/")

		// Decode illegal file name characters (on Windows)
		url = url.replace("%3F", "?")

		url = "http://" + url
		url = url.replace("/index.html", "")
		url = "<a href=\"" + url + "\">" + url + "</a>"
	}
}

i = new ContentTester()
i.list()
