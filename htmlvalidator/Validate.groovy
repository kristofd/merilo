import org.w3c.tidy.*
	
class Validator {

	def PAGE_ROOT = "../webpages/"

	def list() {
		new File(PAGE_ROOT).eachFileRecurse {
			if (it.isFile()) {
				Tidy t = new Tidy()
				String[] params = new String[2]
				params[0] = "-qe"
				params[1] = it.path

				StringWriter s = new StringWriter()
				PrintWriter pw = new PrintWriter(s)
				t.setErrout(pw)
				t.mainExec(params)

				if (s.toString().length() > 0) {
					println ""
					println convertPathToURL(it.path)
					def output = s.toString().replace("\u00A0", "").replace("<", "&lt;").replace(">", "&gt;").replace("\n","<br/>");
					println "<p>" + output + "</p>"
				}
			}
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

i = new Validator()
i.list()
