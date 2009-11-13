package parsing;

import org.htmlparser.Node;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.SimpleNodeIterator;

public abstract class AbstractRecursivePerform extends AbstractPerform {

	public AbstractRecursivePerform(NodeList nl) {
		super(nl);
	}

	protected void performNodeList(NodeList nl) {
		if (nl != null) {
			SimpleNodeIterator nls = nl.elements();
			while (nls.hasMoreNodes()) {
				Node n = nls.nextNode();
				if (n != null) {
					performNodeList(n.getChildren());
					perform(n);
				}
			}
		}
	}

}
