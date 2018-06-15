package com.blog.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import word.api.interfaces.IDocument;
import word.w2004.Document2004;
import word.w2004.Document2004.Encoding;
import word.w2004.elements.BreakLine;
import word.w2004.elements.Heading1;
import word.w2004.elements.Heading3;
import word.w2004.elements.Image;
import word.w2004.elements.Paragraph;
import word.w2004.style.HeadingStyle.Align;

public class SaveDocument {
	
	public static void createDoc(String testCaseName, String[] imgFileNames) {
		// Create a document object
		IDocument myDoc = new Document2004();
		myDoc.encoding(Encoding.UTF_8);
		// Inserts one breakline
		myDoc.addEle(BreakLine.times(1).create()); 
		// Add client logo to document header
		myDoc.getHeader().addEle(Image.from_FULL_LOCAL_PATHL("/Selenium/Logo.png")
				.setHeight("30")
				.setWidth("20")
				.getContent());
		// Add Project name to document header
		myDoc.getHeader().addEle(Heading3.with(" ProjectName").withStyle().align(Align.RIGHT).create());
		// Specify Test case name as document heading
        myDoc.addEle(Heading1.with(testCaseName + " Test Case").withStyle().align(Align.CENTER).create());
        myDoc.addEle(BreakLine.times(1).create());
        // Add a description paragraph
        myDoc.addEle(Paragraph
                .with("Following are the related screenshots")
                .create());
        myDoc.addEle(BreakLine.times(1).create());
        // Add company name to document footer
        myDoc.getFooter().addEle(
                Paragraph.with("@CompanyName").create());
        // Loop through all the image files
        for(String file:imgFileNames){
        	// Insert each image file to the document
        	myDoc.addEle(Image.from_FULL_LOCAL_PATHL(
                                "/Selenium/screenshots/" + file + ".png") 
                                .setHeight("350")
                                .setWidth("500")
                                .getContent());
        	// Insert 2 linebreaks at the end of each inserted image
        	myDoc.addEle(BreakLine.times(2).create());
        }
        // Insert an image from web
        myDoc.addEle(Image
                .from_WEB_URL("http://www.google.com/images/logos/ps_logo2.png"));
        
        // Create the word document specifying a location
        File fileObj = new File("\\Selenium\\" + testCaseName + ".doc");
        PrintWriter writer = null;
        try {
         writer = new PrintWriter(fileObj);
        } catch (FileNotFoundException e) {
         e.printStackTrace();
        }
        
        String myWord = myDoc.getContent();

        writer.println(myWord);
        writer.close();
        // Print a confirmation image to console
        System.out.println("Word document created successfully!");
       }
}
