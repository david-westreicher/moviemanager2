package core;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.SimpleNodeIterator;

public abstract class AbstractPerform {
	public AbstractPerform(NodeList nl) {
		performNodeList(nl);
	}

	public AbstractPerform(String tag, String site) {
		try {
			Parser p = new Parser(site);
			performNodeList(p.parse(new TagNameFilter(tag)));
		} catch (ParserException e) {
			e.printStackTrace();
		}
	}

	protected void performNodeList(NodeList nl) {
		if (nl != null) {
			SimpleNodeIterator nls = nl.elements();
			while (nls.hasMoreNodes()) {
				Node n = nls.nextNode();
				if (n != null) {
					perform(n);
					performNodeList(n.getChildren());
				}
			}
		}
	}

	public abstract void perform(Node node);
}
