package XMLfile;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import DataStructures.BinaryTree;
import DataStructures.BinaryTreeNode;
import DataStructures.DefaultBinaryTree;
import DataStructures.DefaultBinaryTreeNode;
import DataStructures.LinkedListNode;
import DataStructures.LinkedList;

public class XMLReader {

	// INSTANCE FIELDS
	private File xmlFile;
	
	/**
	* constructor
	* @param filename
	*/
	
	public XMLReader(String filename) {
		this.xmlFile = new File (filename);
	}
	
	public BinaryTree<String> buildGameTree()
	{
	DocumentBuilderFactory factory =
	DocumentBuilderFactory.newInstance();
	
	try
	{
	DocumentBuilder builder = factory.newDocumentBuilder();
	Document document = builder.parse(xmlFile);
	
	return parseDecisionTree(document);
	
	}
	catch (SAXException sxe)
	{
	Exception x = sxe;
	if (sxe.getException() != null)
	
	x = sxe.getException();
	x.printStackTrace();
	}
	catch (ParserConfigurationException pce)
	{
	pce.printStackTrace();
	}
	catch (IOException ioe)
	{
	ioe.printStackTrace();
	}
	
	return null;
	}
	
	/**
	* Parses XML Document.
	* @return GameTree.
	*/
	private BinaryTree<String> parseDecisionTree( Document document )
	{
	
	Element xmlRootElement = (Element)document.getDocumentElement();
	BinaryTree<String> myGameTree = new DefaultBinaryTree<String>();
	
	// assume root element is a question
	myGameTree.setRoot(parseQuestionNode( xmlRootElement ));
	
	return myGameTree;
	}
	
	/**
	* Parses a question element.
	*/
	private BinaryTreeNode<String> parseQuestionNode( Element element )
	{
	if (!element.getTagName().equals("question")) {
	System.err.println("Error: expecting question tag");
	}
	
	String questionText = element.getAttribute("text");
	BinaryTreeNode<String> questionNode = new DefaultBinaryTreeNode<String>();
	questionNode.setData(questionText);

	NodeList children = element.getChildNodes();
	for ( int i = 0; i < children.getLength(); i++ ) {
	if ( children.item(i) instanceof Element ) {
	Element childNode = (Element)children.item(i);
	
	String user_response = childNode.getAttribute("user_answer");
	
	if (user_response.equals("yes")) {
	questionNode.setLeftChild(parseAnswerNode(childNode));
	
	}
	else if (user_response.equals("no")){
	questionNode.setRightChild(parseAnswerNode(childNode));
	}
	else{
	System.err.println("Error in XML file: not a valid answer");
	}
	}
	}
	return questionNode;
	}
	
	/**
	* Parses an answer element.
	*/
	private BinaryTreeNode<String> parseAnswerNode(Element element)
	{
	if (!element.getTagName().equals("answer")) {
	System.err.println("Error: expecting answer tag");
	}
	
	NodeList children = element.getChildNodes();
	for (int i = 0; i < children.getLength(); i++) {
	if ( children.item(i) instanceof Element ) {
	
	Element child = (Element)children.item(i);
	
	//basecase: if child is Thing element
	if (child.getTagName().equals("thing")) {
		BinaryTreeNode<String> node= new DefaultBinaryTreeNode<String>();
		node.setData(child.getAttribute("value"));
		return node;
	//return new BinaryTreeNode<String>(child.getAttribute("type"));
	
	//recursive case: child is a question node
	} else if (child.getTagName().equals("question")) {
	return parseQuestionNode(child);
	} 
	else 
			{
				System.err.println("Error: child of answer should be a thing or a question");
			}
		}
	}
	return null;
	}
	/**
	* main method: reads in the selected XML file, builds a tree, prints the
	* tree.
	*/
	public static void main( String[] args){
	XMLReader tr = new XMLReader(args[0]);
	BinaryTree<String> guessingGame = tr.buildGameTree();
	System.out.println("Preorder: " + guessingGame.preorderTraversal());
	
	} 
/**
 * hAVE A NODE GET IT TO ROOT, IF YES LEFT, IF RIGHT NO, IF LEAF GAME OVER
 * SET DATA AD WRITE THE XML FILE BY PASSING IT
 */

}
